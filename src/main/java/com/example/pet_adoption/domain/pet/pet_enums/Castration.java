package com.example.pet_adoption.domain.pet.pet_enums;

public enum Castration {
    CASTRATED("Castrado"),
    ACCESSIBLE("Castração facilitada"),
    GUARANTEED("Castração garantida"),
    NONE("");

    private final String displayName;

    Castration(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
