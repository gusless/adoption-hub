package com.example.pet_adoption.domain.adoption;

import com.example.pet_adoption.domain.accounts.Publisher;
import com.example.pet_adoption.domain.address.Address;

import com.example.pet_adoption.domain.pet.Pet;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "adoptions")
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String title;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @OneToMany(mappedBy = "adoption", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<Pet> pets = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AdoptionStatus status = AdoptionStatus.UP_FOR_ADOPTION;

    @ElementCollection
    @CollectionTable(
            name = "adoption_status_history",
            joinColumns = @JoinColumn(name = "adoption_id")
    )
    @OrderBy("changedAt ASC")
    private final List<StatusChange> statusHistory = new ArrayList<>();

    @Column(length = 2000)
    private String description;

    @Embedded
    private Address address;

    protected Adoption(){}

    public Adoption(String title, Publisher publisher, String description, Address address) {
        this.title = title;
        this.publisher = publisher;
        this.description = description;
        this.address = address;
    }

    public void changeStatus(AdoptionStatus newStatus){
        this.status = newStatus;
        statusHistory.add(new StatusChange(newStatus));
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public AdoptionStatus getStatus() {
        return status;
    }

    public List<StatusChange> getStatusHistory() {
        return statusHistory;
    }

    public String getDescription() {
        return description;
    }

    public Address getAddress() {
        return address;
    }

}
