package com.example.pet_adoption.domain.adoption.dto;

import com.example.pet_adoption.domain.accounts.Publisher;
import com.example.pet_adoption.domain.address.dto.AddressResponse;
import com.example.pet_adoption.domain.adoption.Adoption;
import com.example.pet_adoption.domain.adoption.AdoptionStatus;
import com.example.pet_adoption.domain.pet.dto.PetResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record AdoptionResponse(
        Long id,
        String title,
        Publisher publisher,
        Set<PetResponse> pets,
        AdoptionStatus status,
        LocalDateTime postedAt,
        String description,
        AddressResponse address
) {
    public AdoptionResponse(Adoption adoption){
        this(
                adoption.getId(),
                adoption.getTitle(),
                adoption.getPublisher(),
                adoption.getPets()
                        .stream()
                        .map(PetResponse::fromEntity)
                        .collect(Collectors.toSet()),
                adoption.getStatus(),
                adoption.getPostedAt(),
                adoption.getDescription(),
                new AddressResponse(adoption.getAddress())
        );
    }
}
