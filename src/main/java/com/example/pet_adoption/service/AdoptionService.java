package com.example.pet_adoption.service;

import com.example.pet_adoption.domain.accounts.Publisher;
import com.example.pet_adoption.domain.address.Address;
import com.example.pet_adoption.domain.adoption.Adoption;
import com.example.pet_adoption.domain.adoption.dto.AdoptionRequest;
import com.example.pet_adoption.domain.adoption.dto.AdoptionResponse;
import com.example.pet_adoption.domain.pet.Cat;
import com.example.pet_adoption.domain.pet.Dog;
import com.example.pet_adoption.domain.pet.Pet;
import com.example.pet_adoption.domain.pet.dto.CatRequest;
import com.example.pet_adoption.domain.pet.dto.DogRequest;
import com.example.pet_adoption.domain.pet.dto.PetRequest;
import com.example.pet_adoption.domain.vaccine.Vaccine;
import com.example.pet_adoption.domain.vaccine.dto.PetVaccineRequest;
import com.example.pet_adoption.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AdoptionService {

    private final AdoptionRepository adoptionRepository;
    private final PublisherRepository publisherRepository;
    private final VaccineRepository vaccineRepository;

    public AdoptionService(
            AdoptionRepository adoptionRepository,
            PublisherRepository publisherRepository, VaccineRepository vaccineRepository) {
        this.adoptionRepository = adoptionRepository;
        this.publisherRepository = publisherRepository;
        this.vaccineRepository = vaccineRepository;
    }

    @Transactional
    public AdoptionResponse create(
            @Valid AdoptionRequest newAdoption, Long id) {
        Publisher publisher = publisherRepository.getReferenceById(id);

        Map<Long, Vaccine> vaccinesById = loadVaccines(newAdoption.pets());

        Adoption adoption = new Adoption(
                newAdoption.title(),
                publisher,
                newAdoption.description(),
                new Address(newAdoption.address())
        );

        for (PetRequest petReq : newAdoption.pets()){
            Pet pet = buildPets(petReq, vaccinesById);
            adoption.addPet(pet);
        }

        Adoption saved = adoptionRepository.save(adoption);
        return new AdoptionResponse(saved);

    }

    private Map<Long, Vaccine> loadVaccines(
            @Valid @NotEmpty(message = "A adoção deve conter pelo menos um pet")
            Set<PetRequest> pets) {
        List<Long> vaccineIds = pets.stream()
                .filter(p -> p.vaccinations() != null)
                .flatMap(p -> p.vaccinations().stream())
                .map(PetVaccineRequest::vaccineId)
                .distinct()
                .toList();
        if (vaccineIds.isEmpty()){
            return Map.of();
        }
        return vaccineRepository.findAllById(vaccineIds).stream()
                .collect(Collectors.toMap(Vaccine::getId, Function.identity()));
    }

    private Pet buildPets(PetRequest petRequest, Map<Long, Vaccine> vaccinesById) {
        Pet pet = switch (petRequest){
            case CatRequest catReq -> new Cat(catReq);
            case DogRequest dogReq -> new Dog(dogReq);
        };

        if (petRequest.vaccinations() != null){
            for (PetVaccineRequest vacRec : petRequest.vaccinations()){
                Long vacId = vacRec.vaccineId();
                Vaccine vaccine = vaccinesById.get(vacId);
                if (vaccine == null){
                    throw new EntityNotFoundException("Vacina não encontrada com ID " + vacId);
                }
                pet.addVaccination(vaccine, vacRec.appliedAt(), vacRec.nextDoseAt());
            }
        }

        return pet;


    }
}
