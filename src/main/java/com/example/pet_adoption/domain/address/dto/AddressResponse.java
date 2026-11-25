package com.example.pet_adoption.domain.address.dto;

import com.example.pet_adoption.domain.address.Address;
import com.example.pet_adoption.domain.address.State;

public record AddressResponse(
        String cep,
        State state,
        String city,
        String neighborhood,
        String street,
        String number,
        String complement
) {
    public AddressResponse(Address address){
        this(
                address.getCep(),
                address.getState(),
                address.getCity(),
                address.getNeighborhood(),
                address.getStreet(),
                address.getNumber(),
                address.getComplement()
        );
    }
}
