package com.example.pet_adoption.domain.accounts;

import com.example.pet_adoption.domain.address.Address;
import com.example.pet_adoption.domain.adoption.Adoption;
import jakarta.persistence.*;

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

    @Embedded
    private Address address;

    protected Publisher(){}

    public Publisher(String email, String phone, Address address) {
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public Set<Adoption> getAdoptions() {
        return adoptions;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }
}
