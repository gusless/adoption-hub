package com.example.pet_adoption.repository;

import com.example.pet_adoption.domain.vaccine.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {

}
