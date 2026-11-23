package com.example.pet_adoption.repository;

import com.example.pet_adoption.domain.adoption.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdoptionRepository extends JpaRepository<Adoption, Long> {
}
