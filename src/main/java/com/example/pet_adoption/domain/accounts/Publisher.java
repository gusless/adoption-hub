package com.example.pet_adoption.domain.accounts;

import com.example.pet_adoption.domain.adoption.Adoption;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "publisher")
    private final Set<Adoption> adoptions = new HashSet<>();

    private String email;

    private String phone;
}
