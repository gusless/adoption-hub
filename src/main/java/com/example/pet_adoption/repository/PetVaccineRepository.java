package com.example.pet_adoption.repository;

import com.example.pet_adoption.domain.vaccine.PetVaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetVaccineRepository extends JpaRepository<PetVaccine, Long> {
}
