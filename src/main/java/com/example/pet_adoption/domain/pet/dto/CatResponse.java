package com.example.pet_adoption.domain.pet.dto;

import com.example.pet_adoption.domain.pet.Cat;
import com.example.pet_adoption.domain.pet.pet_enums.*;
import com.example.pet_adoption.domain.vaccine.dto.PetVaccineResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public record CatResponse(
    Long id,
    String name,
    String description,
    Double weight,
    LocalDate birth,
    boolean estimatedBirth,
    CatBreed catBreed, //cat
    PetGenre genre,
    Castration castration,
    Set<GeneralTraits> generalTraits,
    Set<CatTraits> catTraits, //cat
    List<PetVaccineResponse> vaccinations,
    List<String> photoUrls
) implements PetResponse {
    public static CatResponse fromEntity(Cat cat){
        return new CatResponse(
                cat.getId(),
                cat.getName(),
                cat.getDescription(),
                cat.getWeight(),
                cat.getBirth(),
                cat.isEstimatedBirth(),
                cat.getBreed(), //cat
                cat.getGenre(),
                cat.getCastration(),
                cat.getGeneralTraits(),
                cat.getCatTraits(), //cat
                cat.getVaccination()
                        .stream()
                        .map(PetVaccineResponse::new)
                        .toList(),
                cat.getPhotoUrls()
        );
    }
}
