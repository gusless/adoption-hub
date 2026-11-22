package com.example.pet_adoption.domain.pet.pet_enums;

public enum CatTraits {

    LAP_CAT("Gosta de ficar no colo"),
    LAP_AVOIDANT("Evita ficar no colo"),
    PURRING("Ronrona frequentemente"),
    KNEADING("Tem hábito de amassar com as patas"),
    HEAD_BUTTING("Esfrega a cabeça nas pessoas"),
    FOLLOWS_OWNER("Segue o tutor pela casa"),
    WINDOW_WATCHER("Gosta de observar pela janela"),
    SUNBATHER("Gosta de tomar sol"),
    NIGHT_ACTIVE("Ativo durante a noite"),
    CREPUSCULAR("Mais ativo ao amanhecer e entardecer"),
    WATER_AVERSE("Evita água"),
    WATER_PLAYFUL("Gosta de brincar com água"),
    HIGH_SCRATCHING_NEED("Necessita arranhar frequentemente"),
    HIGH_CLIMBING_NEED("Necessita locais para escalar"),
    HIGH_PERCHING_NEED("Gosta de lugares elevados"),
    HIDING_LOVER("Gosta de se esconder"),
    BOX_LOVER("Gosta de caixas"),
    TOY_HUNTER("Gosta de perseguir brinquedos"),
    FETCHING_CAT("Busca objetos para brincar"),
    TALKATIVE_CAT("Gato comunicativo"),
    QUIET_CAT("Gato silencioso"),
    AFFECTIONATE_GROOMING("Demonstra carinho lambendo"),
    SOCIAL_GROOMING("Gosta de lamber outros animais"),
    NIGHT_HUNTER("Instinto de caça noturno"),
    TERRITORIAL_CAT("Territorial com outros gatos"),
    CUDDLY("Gosta de ficar aconchegado");

    private final String displayName;

    CatTraits(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
