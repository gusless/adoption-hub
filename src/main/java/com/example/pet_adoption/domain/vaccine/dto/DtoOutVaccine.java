package com.example.pet_adoption.domain.vaccine.dto;

import com.example.pet_adoption.domain.vaccine.TargetSpecie;
import com.example.pet_adoption.domain.vaccine.Vaccine;

public record DtoOutVaccine(
        Long id,
        String name,
        TargetSpecie targetSpecie
) {
    public DtoOutVaccine(Vaccine vaccine){
        this(
                vaccine.getId(),
                vaccine.getName(),
                vaccine.getTargetSpecie()
        );
    }
}
