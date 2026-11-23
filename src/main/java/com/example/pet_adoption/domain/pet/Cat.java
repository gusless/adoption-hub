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
@DiscriminatorValue("CAT")
public class Cat extends Pet{

    @Enumerated(EnumType.STRING)
    private CatBreed breed;

    @ElementCollection
    @CollectionTable(
            name = "cat_traits",
            joinColumns = @JoinColumn(name = "pet_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "trait")
    private Set<CatTraits> catTraits = new HashSet<>();

    protected Cat(){}

    public Cat(
            String name, String description, Float weight, LocalDate birth,
            boolean estimatedBirth, PetGenre genre, Castration castration,
            Set<GeneralTraits> generalTraits, Address address, Adoption adoption,
            List<PetVaccine> vaccinations, List<String> photoUrls, CatBreed breed,
            Set<CatTraits> catTraits) {
        super(
                name, description, weight, birth, estimatedBirth,
                genre, castration, generalTraits, address, adoption,
                vaccinations, photoUrls);
        this.breed = breed;
        this.catTraits = catTraits;
    }

    @Override
    public TargetSpecie getTargetSpecies() {
        return TargetSpecie.CAT;
    }

    public CatBreed getBreed() {
        return breed;
    }

    public Set<CatTraits> getCatTraits() {
        return catTraits;
    }
}
