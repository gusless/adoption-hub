package com.example.pet_adoption.domain.pet;

import com.example.pet_adoption.domain.address.Address;
import com.example.pet_adoption.domain.adoption.Adoption;
import com.example.pet_adoption.domain.pet.pet_enums.Castration;
import com.example.pet_adoption.domain.pet.pet_enums.GeneralTraits;
import com.example.pet_adoption.domain.vaccine.PetVaccine;
import com.example.pet_adoption.domain.vaccine.TargetSpecies;
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

    private Float weight;

    private LocalDate birth;

    private boolean estimatedBirth;

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

    @Embedded
    private Address address;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "adoption_id", nullable = false)
    private Adoption adoption;

    @OneToMany()
    private List<PetVaccine> vaccinations = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "pet_photos",
            joinColumns = @JoinColumn(name = "pet_id")
    )
    @OrderColumn(name = "display_order")
    @Column(name = "url", nullable = false, length = 500)
    private List<String> photoUrls = new ArrayList<>();

    protected Pet(){}

    public Pet(String name, String description, Float weight, LocalDate birth,
               boolean estimatedBirth, Castration castration, Set<GeneralTraits> generalTraits,
               Address address, ArrayList<PetVaccine> vaccinations, List<String> photoUrls) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.birth = birth;
        this.estimatedBirth = estimatedBirth;
        this.castration = castration;
        this.generalTraits = generalTraits;
        this.address = address;
        this.vaccinations = vaccinations;
        this.photoUrls = photoUrls;
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

    public abstract TargetSpecies getTargetSpecies();

    public void AddVaccination(
            Vaccine vaccine, LocalDate appliedAt, LocalDate nextDoseAt
    ){
        if (vaccine.getTargetSpecies() != this.getTargetSpecies()
        && vaccine.getTargetSpecies() != TargetSpecies.BOTH){
            throw new IllegalArgumentException(
                    "A vacina " + vaccine.getName() + " não é compatível com "
                    + this.getTargetSpecies().getDisplayName() + "s."
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

    public Float getWeight() {
        return weight;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public boolean isEstimatedBirth() {
        return estimatedBirth;
    }

    public Castration getCastration() {
        return castration;
    }

    public Set<GeneralTraits> getGeneralTraits() {
        return generalTraits;
    }

    public Address getAddress() {
        return address;
    }

    public Adoption getAdoption() {
        return adoption;
    }

    public List<PetVaccine> getVaccination() {
        return vaccinations;
    }
}

