package com.example.pet_adoption.repository;

import com.example.pet_adoption.domain.accounts.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
