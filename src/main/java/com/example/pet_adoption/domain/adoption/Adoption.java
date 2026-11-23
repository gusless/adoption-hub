package com.example.pet_adoption.domain.adoption;

import com.example.pet_adoption.domain.accounts.Publisher;
import com.example.pet_adoption.domain.pet.Pet;
import jakarta.persistence.*;

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

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @OneToMany(mappedBy = "adoption")
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

    private String description;

    protected Adoption(){}

    public Adoption(Publisher publisher, String description) {
        this.publisher = publisher;
        this.description = description;
    }

    public void changeStatus(AdoptionStatus newStatus){
        this.status = newStatus;
        statusHistory.add(new StatusChange(newStatus));
    }

    public Long getId() {
        return id;
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
}
