package com.example.pet_adoption.domain.pet.pet_enums;

public enum PetGenre {
    MALE("Macho"),
    FEMALE("Fêmea");

    private final String displayName;

    PetGenre(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
