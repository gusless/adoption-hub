package com.example.pet_adoption.domain.vaccine;

public enum TargetSpecie {
    DOG("Cachorro"),
    CAT("Gato"),
    BOTH("Ambos");

    private final String displayName;

    TargetSpecie(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
