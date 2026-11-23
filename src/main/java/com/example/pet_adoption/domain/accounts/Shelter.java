package com.example.pet_adoption.domain.accounts;

import com.example.pet_adoption.domain.address.Address;
import jakarta.persistence.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

import java.util.*;

@Entity
@Table(name = "shelters")
public class Shelter extends Publisher {

    @Column(name = "shelter_name", nullable = false)
    private String shelterName;

    @Column(nullable = false, updatable = false, length = 14)
    private String cnpj;

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

    public Shelter(String email, String password, String phone, Address address,
                   String shelterName, String cnpj, List<String> photoUrls) {
        super(email, password, phone, address);
        this.shelterName = shelterName;
        this.cnpj = cnpj;
        this.photoUrls = photoUrls;
    }

    public String getShelterName() {
        return shelterName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public Set<User> getCollaborators() {
        return collaborators;
    }
}
