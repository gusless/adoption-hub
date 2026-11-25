package com.example.pet_adoption.domain.pet.dto;

import com.example.pet_adoption.domain.pet.Cat;
import com.example.pet_adoption.domain.pet.Dog;
import com.example.pet_adoption.domain.pet.Pet;
import com.example.pet_adoption.domain.pet.pet_enums.Castration;
import com.example.pet_adoption.domain.pet.pet_enums.GeneralTraits;
import com.example.pet_adoption.domain.pet.pet_enums.PetGenre;
import com.example.pet_adoption.domain.vaccine.PetVaccine;
import com.example.pet_adoption.domain.vaccine.dto.PetVaccineResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public sealed interface PetResponse permits CatResponse, DogResponse {
    Long id();
    String name();
    String description();
    Double weight();
    LocalDate birth();
    boolean estimatedBirth();
    PetGenre genre();
    Castration castration();
    Set<GeneralTraits> generalTraits();
    List<PetVaccineResponse> vaccinations();
    List<String> photoUrls();

    static PetResponse fromEntity(Pet pet){
        return switch (pet) {
            case Cat cat -> CatResponse.fromEntity(cat);
            case Dog dog -> DogResponse.fromEntity(dog);
            default -> throw new IllegalArgumentException("Tipo de pet não suportado");
        };
    }

}
