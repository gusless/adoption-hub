package com.example.pet_adoption.domain.accounts;

public enum Genre {
    MALE("Masculino"),
    FEMALE("Feminino"),
    OTHER("Outro");

    private final String displayName;

    Genre(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
