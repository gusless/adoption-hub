package com.example.pet_adoption.domain.pet;

import com.example.pet_adoption.domain.address.Address;
import com.example.pet_adoption.domain.adoption.Adoption;
import com.example.pet_adoption.domain.pet.pet_enums.*;
import com.example.pet_adoption.domain.vaccine.PetVaccine;
import com.example.pet_adoption.domain.vaccine.TargetSpecie;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("DOG")
public class Dog extends Pet {

    @Enumerated(EnumType.STRING)
    private DogBreed breed;

    @ElementCollection
    @CollectionTable(
            name = "dog_traits",
            joinColumns = @JoinColumn(name = "pet_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "trait")
    private Set<DogTraits> dogTraits = new HashSet<>();

    protected Dog(){}

    public Dog(
            String name, String description, Float weight, LocalDate birth,
            boolean estimatedBirth, PetGenre genre, Castration castration,
            Set<GeneralTraits> generalTraits, Address address, Adoption adoption,
            List<PetVaccine> vaccinations, List<String> photoUrls, DogBreed breed,
            Set<DogTraits> dogTraits) {
        super(
                name, description, weight, birth, estimatedBirth,
                genre, castration, generalTraits, address, adoption,
                vaccinations, photoUrls);
        this.breed = breed;
        this.dogTraits = dogTraits;
    }

    @Override
    public TargetSpecie getTargetSpecies() {
        return TargetSpecie.DOG;
    }

    public DogBreed getBreed() {
        return breed;
    }

    public Set<DogTraits> getDogTraits() {
        return dogTraits;
    }
}
