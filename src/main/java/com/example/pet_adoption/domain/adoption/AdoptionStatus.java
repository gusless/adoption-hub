package com.example.pet_adoption.domain.adoption;

public enum AdoptionStatus {
    UP_FOR_ADOPTION("Para adoção"),
    IN_PROGRESS("Adoção em progresso"),
    ADOPTED("Adotado"),
    CANCELED("Adoção Cancelada");

    private final String displayName;

    AdoptionStatus(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
