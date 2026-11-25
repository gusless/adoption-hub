package com.example.pet_adoption.domain.vaccine.dto;

import com.example.pet_adoption.domain.vaccine.TargetSpecie;
import jakarta.validation.constraints.NotBlank;

public record VaccineUpdateRequest(
        @NotBlank
        String name,
        @NotBlank
        TargetSpecie targetSpecie
) {
}
