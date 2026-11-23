package com.example.pet_adoption.repository;

import com.example.pet_adoption.domain.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
