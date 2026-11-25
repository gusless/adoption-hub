package com.example.pet_adoption.domain.vaccine;

import com.example.pet_adoption.domain.vaccine.dto.VaccineRequest;
import com.example.pet_adoption.domain.vaccine.dto.VaccineUpdateRequest;
import jakarta.persistence.*;
import jakarta.validation.Valid;

@Entity
@Table(name = "vaccines")
public class Vaccine{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "target_specie", nullable = false)
    private TargetSpecie targetSpecie;

    protected Vaccine(){}

    public Vaccine(String name, TargetSpecie targetSpecie) {
        this.name = name;
        this.targetSpecie = targetSpecie;
    }

    public Vaccine(VaccineRequest newVaccine) {
        this.name = newVaccine.name();
        this.targetSpecie = newVaccine.targetSpecie();
    }

    public void updateInfos(@Valid VaccineUpdateRequest vaccineUpdated) {
        this.name = vaccineUpdated.name();
        this.targetSpecie = getTargetSpecie();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TargetSpecie getTargetSpecie() {
        return targetSpecie;
    }


}
