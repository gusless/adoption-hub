package com.example.pet_adoption.domain.pet;

import com.example.pet_adoption.domain.accounts.User;
import com.example.pet_adoption.domain.address.Address;
import com.example.pet_adoption.domain.adoption.Adoption;
import com.example.pet_adoption.domain.pet.dto.DogRequest;
import com.example.pet_adoption.domain.pet.dto.PetRequest;
import com.example.pet_adoption.domain.pet.pet_enums.Castration;
import com.example.pet_adoption.domain.pet.pet_enums.GeneralTraits;
import com.example.pet_adoption.domain.pet.pet_enums.PetGenre;
import com.example.pet_adoption.domain.vaccine.PetVaccine;
import com.example.pet_adoption.domain.vaccine.TargetSpecie;
import com.example.pet_adoption.domain.vaccine.Vaccine;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pets")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pet_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double weight;

    private LocalDate birth;

    private boolean estimatedBirth;

    @Enumerated(EnumType.STRING)
    private PetGenre genre;

    @Enumerated(EnumType.STRING)
    private Castration castration;

    @ElementCollection
    @CollectionTable(
            name = "general_traits",
            joinColumns = @JoinColumn(name = "pet_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "trait")
    private Set<GeneralTraits> generalTraits = new HashSet<>();

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "adoption_id", nullable = false)
    private Adoption adoption;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PetVaccine> vaccinations = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "pet_photos",
            joinColumns = @JoinColumn(name = "pet_id")
    )
    @OrderColumn(name = "display_order")
    @Column(name = "url", nullable = false, length = 500)
    private List<String> photoUrls = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adopter_id")
    private User adopter;

    protected Pet(){}

    public Pet(
            String name, String description, Double weight, LocalDate birth,
            boolean estimatedBirth, PetGenre genre, Castration castration,
            Set<GeneralTraits> generalTraits, Adoption adoption,
            List<PetVaccine> vaccinations, List<String> photoUrls) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.birth = birth;
        this.estimatedBirth = estimatedBirth;
        this.genre = genre;
        this.castration = castration;
        this.generalTraits = generalTraits;
        this.adoption = adoption;
        this.vaccinations = vaccinations;
        this.photoUrls = photoUrls;
    }

    public Pet(PetRequest petRequest) {
        this.name = petRequest.name();
        this.description= petRequest.description();
        this.weight = petRequest.weight();
        this.birth = petRequest.birth();
        this.estimatedBirth = petRequest.estimatedBirth();
        this.genre = petRequest.genre();
        this.castration = petRequest.castration();
        this.generalTraits = petRequest.generalTraits();
        this.photoUrls = new ArrayList<>(petRequest.photoUrls());
    }

    @Transient
    public Period getAge(){
        if (this.birth == null){
            throw new NullPointerException("A idade não pode ser vazia");
        }
        return Period.between(birth, LocalDate.now());
    }

    public void AddPhotoUrl(String url){
        if (this.photoUrls.size() >= 10){
            throw new IllegalStateException("Limite máximo de 10 fotos por pet excedido");
        }
        this.photoUrls.add(url);
    }

    public abstract TargetSpecie getTargetSpecies();

    public void addVaccination(
            Vaccine vaccine, LocalDate appliedAt, LocalDate nextDoseAt
    ){
        if (vaccine.getTargetSpecie() != this.getTargetSpecies()
        && vaccine.getTargetSpecie() != TargetSpecie.BOTH){
            throw new IllegalArgumentException(
                    "A vacina " + vaccine.getName() + " não é compatível com "
                    + this.getTargetSpecies().getDisplayName().toLowerCase() + "s."
            );
        }
        this.vaccinations.add(new PetVaccine(this, vaccine, appliedAt, nextDoseAt));
    }

    public void removeVaccination(PetVaccine vaccination){
        this.vaccinations.remove(vaccination);
        vaccination.setPet(null);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getWeight() {
        return weight;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public boolean isEstimatedBirth() {
        return estimatedBirth;
    }

    public PetGenre getGenre() {
        return genre;
    }

    public Castration getCastration() {
        return castration;
    }

    public Set<GeneralTraits> getGeneralTraits() {
        return generalTraits;
    }

    public Adoption getAdoption() {
        return adoption;
    }

    public List<PetVaccine> getVaccination() {
        return vaccinations;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public User getAdopter() {
        return adopter;
    }
}

