package com.example.pet_adoption.domain.vaccine;

import com.example.pet_adoption.domain.pet.Pet;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vaccines")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "vaccine")
    private Set<Pet> pets = new HashSet<>();
}
