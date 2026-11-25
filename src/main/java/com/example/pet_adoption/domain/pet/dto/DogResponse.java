package com.example.pet_adoption.domain.pet.dto;

import com.example.pet_adoption.domain.pet.Dog;
import com.example.pet_adoption.domain.pet.pet_enums.*;
import com.example.pet_adoption.domain.vaccine.dto.PetVaccineResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public record DogResponse(
        Long id,
        String name,
        String description,
        Double weight,
        LocalDate birth,
        boolean estimatedBirth,
        DogBreed breed, //dog
        PetGenre genre,
        Castration castration,
        Set<GeneralTraits> generalTraits,
        Set<DogTraits> dogTraits, //dog
        List<PetVaccineResponse> vaccinations,
        List<String> photoUrls
) implements PetResponse {
    public static DogResponse fromEntity(Dog dog){
        return new DogResponse(
                dog.getId(),
                dog.getName(),
                dog.getDescription(),
                dog.getWeight(),
                dog.getBirth(),
                dog.isEstimatedBirth(),
                dog.getBreed(), //dog
                dog.getGenre(),
                dog.getCastration(),
                dog.getGeneralTraits(),
                dog.getDogTraits(), //dog
                dog.getVaccination()
                        .stream()
                        .map(PetVaccineResponse::new)
                        .toList(),
                dog.getPhotoUrls()
        );
    }
}
