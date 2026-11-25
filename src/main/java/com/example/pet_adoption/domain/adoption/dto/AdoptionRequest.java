package com.example.pet_adoption.domain.adoption.dto;

import com.example.pet_adoption.domain.address.dto.AddressRequest;
import com.example.pet_adoption.domain.pet.dto.PetRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

public record AdoptionRequest(
        @NotBlank @Length(max = 30, message = "O título deve haver no máximo 30 caracteres")
        String title,
        @Valid
        @NotEmpty(message = "A adoção deve conter pelo menos um pet")
        Set<PetRequest> pets,
        @NotBlank(message = "Deve ser feita uma descrição da adoção")
        @Length(max = 2000, message = "A descrição deve ter no máximo 2000 caracteres")
        String description,
        @Valid @NotEmpty(message = "Deve ser escolhido um endereço válido")
        AddressRequest address
) {
}
