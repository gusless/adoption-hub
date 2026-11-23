package com.example.pet_adoption.domain.vaccine;

public enum TargetSpecies {
    DOG("Cachorro"),
    CAT("Gato"),
    BOTH("ambos");

    private String displayName;

    TargetSpecies(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
