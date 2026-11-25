package com.example.pet_adoption.domain.vaccine.dto;

import com.example.pet_adoption.domain.vaccine.TargetSpecie;
import com.example.pet_adoption.domain.vaccine.Vaccine;

public record VaccineResponse(
        Long id,
        String name,
        TargetSpecie targetSpecie
) {
    public VaccineResponse(Vaccine vaccine){
        this(
                vaccine.getId(),
                vaccine.getName(),
                vaccine.getTargetSpecie()
        );
    }
}
