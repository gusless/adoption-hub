package com.example.pet_adoption.domain.adoption;

public enum AdoptionStatus {
    UP_FOR_ADOPTION("Para adoção"),
    ADOPTION_IN_PROGRESS("Adoção em progresso"),
    ADOPTED("Adotado");

    private final String displayName;

    AdoptionStatus(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
