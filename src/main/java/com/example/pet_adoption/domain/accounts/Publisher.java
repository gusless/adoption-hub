package com.example.pet_adoption.domain.accounts;

import com.example.pet_adoption.domain.address.Address;
import com.example.pet_adoption.domain.adoption.Adoption;
import jakarta.persistence.*;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NullMarked
public abstract class Publisher implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @OneToMany(mappedBy = "publisher")
    protected final Set<Adoption> adoptions = new HashSet<>();

    @Column(nullable = false)
    protected String email;

    @Column(nullable = false)
    private String password;

    private boolean active = true;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @Column(nullable = false, length = 11)
    protected String phone;

    @Embedded
    protected Address address;

    protected Publisher(){}

    public Publisher(String email, String password, String phone, Address address) {
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.role.name()));
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public Set<Adoption> getAdoptions() {
        return adoptions;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }
}
