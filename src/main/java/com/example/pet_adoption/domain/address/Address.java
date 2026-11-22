package com.example.pet_adoption.domain.address;

import com.example.pet_adoption.domain.pet.Pet;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;
    private String state;
    private String city;
    private String neighbor;
    private String street;
    private String number;
    private String complement;

    public Long getId() {
        return id;
    }


    public String getCep() {
        return cep;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getNeighbor() {
        return neighbor;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }
}
