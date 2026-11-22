package com.example.pet_adoption.domain.pet.pet_enums;

public enum DogTraits {

    RETRIEVER("Gosta de buscar objetos"),
    HERDING_DOG("Apresenta comportamento de pastoreio"),
    GUARD_DOG("Apresenta comportamento de guarda"),
    WATCHDOG("Alerta sobre a presença de estranhos"),
    SLED_DOG("Adaptado a atividades de tração"),
    WORKING_DOG("Possui aptidão para atividades de trabalho"),
    SPORTING_DOG("Possui aptidão para atividades esportivas"),
    COMPANION_DOG("Perfil de cão de companhia"),
    SCENT_HOUND("Possui aptidão para rastreamento por odor"),
    DIGGER("Gosta de cavar"),
    CHEWER("Gosta de roer objetos"),
    FETCH_LOVER("Adora brincar de buscar objetos"),
    TUG_OF_WAR_LOVER("Gosta de cabo de guerra"),
    SNOW_LOVER("Gosta de brincar na neve"),
    RUNNING_COMPANION("Bom companheiro para corridas"),
    HIKING_COMPANION("Bom companheiro para trilhas"),
    BIKE_COMPANION("Bom companheiro para passeios de bicicleta"),
    ADVENTUROUS_OUTDOORS("Aventureiro ao ar livre"),
    HERDING_INSTINCT("Instinto de pastoreio"),
    GUARDING_INSTINCT("Instinto de guarda"),
    PROTECTIVE_INSTINCT("Instinto de proteção"),
    WALKING_COMPANION("Bom companheiro para caminhadas");

    private final String displayName;

    DogTraits(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
