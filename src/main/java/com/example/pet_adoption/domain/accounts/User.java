package com.example.pet_adoption.domain.accounts;


import com.example.pet_adoption.domain.address.Address;
import com.example.pet_adoption.domain.pet.Pet;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends Publisher {

    @Column(nullable = false)
    private String name;

    @Column(updatable = false, nullable = false, length = 11)
    private String cpf;

    @Column(name = "user_photo", length = 500)
    private String photoUrl;

    @Column(nullable = false, updatable = false)
    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToMany(mappedBy = "collaborators")
    private final Set<Shelter> shelters = new HashSet<>();

    @OneToMany(mappedBy = "adopter")
    private final Set<Pet> adoptedPets = new HashSet<>();

    protected User(){}

    public User(String email, String password, String phone,
                Address address, String name, String cpf, String photoUrl,
                LocalDate birth, Genre genre) {
        super(email, password, phone, address);
        this.name = name;
        this.cpf = cpf;
        this.photoUrl = photoUrl;
        this.birth = birth;
        this.genre = genre;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public Genre getGenre() {
        return genre;
    }

    public Set<Shelter> getShelters() {
        return shelters;
    }

    public Set<Pet> getAdoptedPets() {
        return adoptedPets;
    }
}
