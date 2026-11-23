package com.example.pet_adoption.repository;

import com.example.pet_adoption.domain.accounts.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {
}
