package com.example.pet_adoption.domain.vaccine.dto;

import com.example.pet_adoption.domain.vaccine.PetVaccine;

import java.time.LocalDate;

public record PetVaccineResponse(
        Long id,
        VaccineResponse vaccine,
        LocalDate appliedAt,
        LocalDate nextDoseAt
) {
    public PetVaccineResponse(PetVaccine vaccination){
        this(
                vaccination.getId(),
                new VaccineResponse(vaccination.getVaccine()),
                vaccination.getAppliedAt(),
                vaccination.getNextDoseAt()
        );
    }
}
