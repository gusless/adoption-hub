package com.example.pet_adoption.domain.address;

import com.example.pet_adoption.domain.pet.Pet;
import jakarta.persistence.*;

import java.util.List;

@Embeddable
public class Address {

    @Column(name = "cep", length = 7, nullable = false)
    private String cep;

    @Column(name = "state", length = 2, nullable = false)
    private String state;

    @Column(name = "city", length = 100, nullable = false)
    private String city;

    @Column(name = "neighborhood", length = 100, nullable = false)
    private String neighborhood;

    @Column(name = "street", length = 150, nullable = false)
    private String street;

    @Column(name = "number", length = 20)
    private String number;

    @Column(name = "complement", length = 100)
    private String complement;

    protected Address(){}

    public Address(String cep, String state, String city, String neighborhood,
                   String street, String number, String complement) {
        this.cep = cep;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
        this.complement = complement;
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
        return neighborhood;
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
