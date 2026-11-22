package com.example.pet_adoption.domain.pet.pet_enums;

public enum CatBreed {

    // Raças de pelo curto
    AMERICAN_SHORTHAIR("American Shorthair"),
    BRITISH_SHORTHAIR("British Shorthair"),
    EUROPEAN_SHORTHAIR("European Shorthair"),
    EXOTIC_SHORTHAIR("Exotic Shorthair"),
    ORIENTAL_SHORTHAIR("Oriental Shorthair"),
    SIAMESE("Siamês"),
    THAI("Thai"),
    BURMESE("Burmês"),
    TONKINESE("Tonquinês"),
    BENGAL("Bengal"),
    EGYPTIAN_MAU("Mau Egípcio"),
    ABYSSINIAN("Abissínio"),
    RUSSIAN_BLUE("Azul Russo"),
    CHARTREUX("Chartreux"),
    KORAT("Korat"),
    SINGAPURA("Singapura"),
    HAVANA_BROWN("Havana Brown"),
    MANX("Manx"),
    JAPANESE_BOBTAIL("Bobtail Japonês"),
    KURILIAN_BOBTAIL("Bobtail Kuriliano"),
    AMERICAN_BOBTAIL("Bobtail Americano"),
    PIXIE_BOB("Pixie-bob"),
    OCICAT("Ocicat"),
    BURMILLA("Burmilla"),
    ASIAN_SHORTHAIR("Asian Shorthair"),
    SNOWSHOE("Snowshoe"),
    SELKIRK_REX("Selkirk Rex"),
    CORNISH_REX("Cornish Rex"),
    DEVON_REX("Devon Rex"),
    GERMAN_REX("German Rex"),
    URAL_REX("Ural Rex"),
    LAPERM("LaPerm"),
    SPHYNX("Sphynx"),
    DONSKOY("Donskoy"),
    PETERBALD("Peterbald"),
    LIKOI("Lykoi"),

    // Raças de pelo longo e semilongo
    PERSIAN("Persa"),
    MAINE_COON("Maine Coon"),
    NORWEGIAN_FOREST("Norueguês da Floresta"),
    SIBERIAN("Siberiano"),
    RAGDOLL("Ragdoll"),
    BIRMAN("Sagrado da Birmânia"),
    TURKISH_ANGORA("Angorá Turco"),
    TURKISH_VAN("Van Turco"),
    SOMALI("Somali"),
    BALINESE("Balinês"),
    JAVANESE("Javanês"),
    HIMALAYAN("Himalaio"),
    NEBELUNG("Nebelung"),
    BRITISH_LONGHAIR("British Longhair"),
    SCOTTISH_LONGHAIR("Scottish Longhair"),
    SELKIRK_REX_LONGHAIR("Selkirk Rex de Pelo Longo"),
    ORIENTAL_LONGHAIR("Oriental de Pelo Longo"),
    AMERICAN_CURL_LONGHAIR("American Curl de Pelo Longo"),
    AMERICAN_CURL_SHORTHAIR("American Curl de Pelo Curto"),
    SOMALI_LONGHAIR("Somali de Pelo Longo"),

    // Raças de aparência diferenciada
    SCOTTISH_FOLD("Scottish Fold"),
    SCOTTISH_STRAIGHT("Scottish Straight"),
    MUNCHKIN("Munchkin"),
    DWELF("Dwelf"),
    ELF_CAT("Elf Cat"),
    MINUET("Minuet"),
    KINKALOW("Kinkalow"),
    LAMBKIN("Lambkin"),
    BAMBINO("Bambino"),
    TOYGER("Toyger"),
    SAVANNAH("Savannah"),
    CHAUSIE("Chausie"),
    SERENGETI("Serengeti"),
    KANAANI("Kanaani"),
    SAFARI("Safari"),
    CARACAT("Caracat"),

    // Raças orientais e asiáticas
    BURMESE_EUROPEAN("Burmês Europeu"),
    BURMESE_AMERICAN("Burmês Americano"),
    ORIENTAL("Oriental"),
    KHAO_MANEE("Khao Manee"),
    KHAO_MANE("Khao Manee"),
    KORAT_THAI("Korat Tailandês"),
    THAI_LILAC("Thai Lilac"),
    MEKONG_BOBTAIL("Bobtail do Mekong"),
    DRAGON_LI("Dragon Li"),
    JAPANESE_BOBTAIL_LONGHAIR("Bobtail Japonês de Pelo Longo"),

    // Raças americanas e europeias
    AMERICAN_WIREHAIR("American Wirehair"),
    AMERICAN_RINGTAIL("American Ringtail"),
    CALIFORNIA_SPANGLED("California Spangled"),
    BRAZILIAN_SHORTHAIR("Pelo Curto Brasileiro"),
    EUROPEAN_BURMESE("Burmês Europeu"),
    CYMRIC("Cymric"),
    MANX_LONGHAIR("Manx de Pelo Longo"),
    COLORPOINT_SHORTHAIR("Colorpoint Shorthair"),
    OJOS_AZULES("Ojos Azules"),
    YORK_CHOCOLATE("York Chocolate"),

    // Outras raças
    AUSTRALIAN_MIST("Australian Mist"),
    MINSKIN("Minskin"),
    PALLAS_CAT("Gato-de-Pallas"),
    TIBETAN_CAT("Gato Tibetano"),
    ALPINE_LYNX("Alpine Lynx"),

    // Sem raça definida
    SRD("Sem Raça Definida"),
    DOMESTIC_SHORTHAIR("Pelo Curto Doméstico"),
    DOMESTIC_MEDIUMHAIR("Pelo Médio Doméstico"),
    DOMESTIC_LONGHAIR("Pelo Longo Doméstico"),
    MESTICO("Mestiço");

    private final String displayName;

    CatBreed(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
