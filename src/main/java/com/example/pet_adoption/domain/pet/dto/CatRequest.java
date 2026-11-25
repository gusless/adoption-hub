package com.example.pet_adoption.domain.pet.dto;

import com.example.pet_adoption.domain.address.dto.AddressRequest;
import com.example.pet_adoption.domain.pet.pet_enums.*;
import com.example.pet_adoption.domain.vaccine.dto.PetVaccineRequest;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public record CatRequest(
        String name,
        String description,
        @Max(value = 30, message = "O peso máximo exigido é 30kg.")
        Double weight,
        LocalDate birth,
        boolean estimatedBirth,
        @NotBlank(message = "O gato deve ter uma raça, caso não saiba, selecione Sem Raça Definida (SRD)")
        CatBreed breed, //cat
        PetGenre genre,
        Castration castration,
        Set<GeneralTraits> generalTraits,
        @NotEmpty(message = "Deve haver pelo menos uma característica do gato")
        Set<CatTraits> catTraits, //cat
        List<String> photoUrls,
        List<PetVaccineRequest> vaccinations
        ) implements PetRequest {
}
