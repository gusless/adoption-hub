package com.example.pet_adoption.domain.adoption;

import com.example.pet_adoption.domain.accounts.Publisher;
import com.example.pet_adoption.domain.pet.Pet;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "adoptions")
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @OneToMany(mappedBy = "adoption")
    private final Set<Pet> pets = new HashSet<>();

    private String description;

}
