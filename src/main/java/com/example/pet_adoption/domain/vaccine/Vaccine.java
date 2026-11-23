package com.example.pet_adoption.domain.vaccine;

import jakarta.persistence.*;

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
    private TargetSpecies targetSpecies;

    protected Vaccine(){}

    public Vaccine(String name, TargetSpecies targetSpecies) {
        this.name = name;
        this.targetSpecies = targetSpecies;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TargetSpecies getTargetSpecies() {
        return targetSpecies;
    }
}
