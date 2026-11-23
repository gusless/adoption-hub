package com.example.pet_adoption.domain.vaccine;

import com.example.pet_adoption.domain.pet.Pet;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(
        name = "pet_vaccines",
        uniqueConstraints = @UniqueConstraint(columnNames = {
                "pet_id", "vaccine_id", "applied_ad"
        })
)
public class PetVaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vaccine_id", nullable = false)
    private Vaccine vaccine;

    @Column(name = "applied_at", nullable = false)
    private LocalDate appliedAt;

    @Column(name = "next_dose_at")
    private LocalDate nextDoseAt;

    protected PetVaccine(){}

    public PetVaccine(
            Pet pet, Vaccine vaccine,
            LocalDate appliedAt, LocalDate nextDoseAt) {
        this.pet = pet;
        this.vaccine = vaccine;
        this.appliedAt = appliedAt;
        this.nextDoseAt = nextDoseAt;
    }

    public Long getId() {
        return id;
    }

    public Pet getPet() {
        return pet;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public LocalDate getAppliedAt() {
        return appliedAt;
    }

    public LocalDate getNextDoseAt() {
        return nextDoseAt;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
