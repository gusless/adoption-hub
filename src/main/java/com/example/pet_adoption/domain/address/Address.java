package com.example.pet_adoption.domain.address;

import com.example.pet_adoption.domain.address.dto.AddressRequest;
import com.example.pet_adoption.domain.pet.Pet;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Embeddable
public class Address {

    @Column(name = "cep", length = 8, nullable = false)
    private String cep;

    @Column(name = "state", length = 2, nullable = false)
    @Enumerated(EnumType.STRING)
    private State state;

    @Column(name = "city", length = 40, nullable = false)
    private String city;

    @Column(name = "neighborhood", length = 100, nullable = false)
    private String neighborhood;

    @Column(name = "street", length = 150, nullable = false)
    private String street;

    @Column(name = "number", length = 20, nullable = false)
    private String number;

    @Column(name = "complement", length = 150)
    private String complement;

    protected Address(){}

    public Address(String cep, State state, String city, String neighborhood,
                   String street, String number, String complement) {
        setCep(cep);
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        setNumber(number);
        this.complement = complement;
    }

    public Address(
            @Valid
            @NotEmpty(message = "Deve ser escolhido um endereço válido")
            AddressRequest address) {
        setCep(address.cep());
        this.state = address.state();
        this.city = address.city();
        this.neighborhood = address.neighborhood();
        this.street = address.street();
        setNumber(address.number());
        this.complement = address.complement();
    }

    public void setCep(String cep) {
        this.cep = (cep != null)
                ? cep.replaceAll("\\D", "")
                : null;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = (city != null)
                ? city.trim()
                : null;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = (neighborhood != null)
                ? neighborhood.trim()
                : null;
    }

    public void setStreet(String street) {
        this.street = (street != null)
                ? street.trim()
                : null;
    }

    public void setNumber(String number) {
        this.number = (number != null)
                ? number.trim().toUpperCase()
                : "S/N";
    }

    public void setComplement(String complement) {
        this.complement = (complement != null)
                ? complement.trim()
                : null;
    }

    public String getCep() {
        return cep;
    }

    public State getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getNeighborhood() {
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
