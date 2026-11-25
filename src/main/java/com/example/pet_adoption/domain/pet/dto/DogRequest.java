package com.example.pet_adoption.domain.pet.dto;

import com.example.pet_adoption.domain.address.dto.AddressRequest;
import com.example.pet_adoption.domain.pet.pet_enums.*;
import com.example.pet_adoption.domain.vaccine.dto.PetVaccineRequest;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public record DogRequest(
        String name,
        String description,
        @Max(value = 160, message = "O peso máximo exigido é 160kg.")
        Double weight,
        LocalDate birth,
        boolean estimatedBirth,
        @NotBlank(message = "O cachorro deve ter uma raça, caso não saiba, selecione Sem Raça Definida (SRD)")
        DogBreed breed, //dog
        PetGenre genre,
        Castration castration,
        Set<GeneralTraits> generalTraits,
        @NotEmpty(message = "Deve haver pelo menos uma característica do cachorro")
        Set<DogTraits> dogTraits,
        List<String> photoUrls,
        List<PetVaccineRequest> vaccinations
) implements PetRequest {
}
