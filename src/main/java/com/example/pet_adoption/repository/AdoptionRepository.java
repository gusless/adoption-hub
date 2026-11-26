package com.example.pet_adoption.repository;

import com.example.pet_adoption.domain.adoption.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdoptionRepository extends JpaRepository<Adoption, Long> {
}
