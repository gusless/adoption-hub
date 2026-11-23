package com.example.pet_adoption.domain.accounts;

import com.example.pet_adoption.domain.address.Address;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "shelters")
public class Shelter extends Publisher {

    @ElementCollection
    @CollectionTable(
            name = "shelter_photos",
            joinColumns = @JoinColumn(name = "shelter_id")
    )
    @OrderColumn(name = "display_order")
    @Column(name = "url", length = 500, nullable = false)
    private List<String> photoUrls = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "shelter_collaborator",
            joinColumns = @JoinColumn(name = "shelter_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private final Set<User> collaborators = new HashSet<>();

    protected Shelter(){}

    public Shelter(String email, String phone, Address address, List<String> photoUrls) {
        super(email, phone, address);
        this.photoUrls = photoUrls;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public Set<User> getCollaborators() {
        return collaborators;
    }
}
