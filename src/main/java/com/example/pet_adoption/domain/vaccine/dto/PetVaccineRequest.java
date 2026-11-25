package com.example.pet_adoption.domain.vaccine.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record PetVaccineRequest(
        @NotBlank
        Long vaccineId,
        @NotBlank @PastOrPresent
        LocalDate appliedAt,
        @Future
        LocalDate nextDoseAt
) {

}
