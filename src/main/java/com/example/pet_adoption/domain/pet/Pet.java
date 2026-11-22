package com.example.pet_adoption.domain.pet;

import com.example.pet_adoption.domain.address.Address;
import com.example.pet_adoption.domain.adoption.Adoption;
import com.example.pet_adoption.domain.pet.pet_enums.Castration;
import com.example.pet_adoption.domain.pet.pet_enums.CatTraits;
import com.example.pet_adoption.domain.pet.pet_enums.GeneralTraits;
import com.example.pet_adoption.domain.vaccine.Vaccine;
import jakarta.persistence.*;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
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

    @OneToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "adoption_id", nullable = false)
    private Adoption adoption;

    @ManyToMany
    @JoinTable(
            name = "pet_vaccine",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "vaccine_id")
    )
    private Set<Vaccine> vaccines = new HashSet<>();

    public Pet(){}

    public Pet(String name, String description, Float weight, LocalDate birth,
               boolean estimatedBirth, Castration castration, Set<GeneralTraits> generalTraits,
               Address address, Set<Vaccine> vaccines) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.birth = birth;
        this.estimatedBirth = estimatedBirth;
        this.castration = castration;
        this.generalTraits = generalTraits;
        this.address = address;
        this.vaccines = vaccines;
    }

    @Transient
    public Period getAge(){
        if (this.birth == null){
            throw new RuntimeException("A idade não pode ser vazia");
        }
        return Period.between(birth, LocalDate.now());
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

    public Set<Vaccine> getVaccines() {
        return vaccines;
    }
}

