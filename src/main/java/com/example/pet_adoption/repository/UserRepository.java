package com.example.pet_adoption.repository;

import com.example.pet_adoption.domain.accounts.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
