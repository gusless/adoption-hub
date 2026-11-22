package com.example.pet_adoption.domain.pet;

import com.example.pet_adoption.domain.address.Address;
import com.example.pet_adoption.domain.pet.pet_enums.Castration;
import com.example.pet_adoption.domain.pet.pet_enums.CatBreed;
import com.example.pet_adoption.domain.pet.pet_enums.CatTraits;
import com.example.pet_adoption.domain.pet.pet_enums.GeneralTraits;
import com.example.pet_adoption.domain.vaccine.Vaccine;
import jakarta.persistence.*;
import org.hibernate.annotations.Collate;

import java.time.LocalDate;
import java.util.HashSet;
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

    public Cat(){}

    public Cat(
            String name, String description, Float weight, LocalDate birth,
            boolean estimatedBirth, Castration castration, Set<GeneralTraits> generalTraits,
            Address address, Set<Vaccine> vaccines,
            CatBreed breed, Set<CatTraits> catTraits
    ) {
        super(
                name, description, weight, birth,
                estimatedBirth, castration, generalTraits,
                address, vaccines
        );
        this.breed = breed;
        this.catTraits = catTraits;
    }

    public CatBreed getBreed() {
        return breed;
    }

    public Set<CatTraits> getCatTraits() {
        return catTraits;
    }
}
