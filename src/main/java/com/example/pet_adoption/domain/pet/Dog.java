package com.example.pet_adoption.domain.pet;

import com.example.pet_adoption.domain.address.Address;
import com.example.pet_adoption.domain.pet.pet_enums.Castration;
import com.example.pet_adoption.domain.pet.pet_enums.DogBreed;
import com.example.pet_adoption.domain.pet.pet_enums.DogTraits;
import com.example.pet_adoption.domain.pet.pet_enums.GeneralTraits;
import com.example.pet_adoption.domain.vaccine.PetVaccine;
import com.example.pet_adoption.domain.vaccine.TargetSpecies;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
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
            boolean estimatedBirth, Castration castration, Set<GeneralTraits> generalTraits,
            Address address, ArrayList<PetVaccine> vaccinations, List<String> photoUrls,
            DogBreed breed, Set<DogTraits> dogTraits
    ) {
        super(
                name, description, weight, birth, estimatedBirth,
                castration, generalTraits, address, vaccinations, photoUrls
        );
        this.breed = breed;
        this.dogTraits = dogTraits;
    }

    @Override
    public TargetSpecies getTargetSpecies() {
        return TargetSpecies.DOG;
    }

    public DogBreed getBreed() {
        return breed;
    }

    public Set<DogTraits> getDogTraits() {
        return dogTraits;
    }
}
