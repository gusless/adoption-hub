package com.example.pet_adoption.domain.pet.dto;

import com.example.pet_adoption.domain.address.dto.AddressRequest;
import com.example.pet_adoption.domain.pet.pet_enums.Castration;
import com.example.pet_adoption.domain.pet.pet_enums.GeneralTraits;
import com.example.pet_adoption.domain.pet.pet_enums.PetGenre;
import com.example.pet_adoption.domain.vaccine.dto.PetVaccineRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public sealed interface PetRequest permits CatRequest, DogRequest {
    @NotBlank @Length(max = 30, message = "O nome deve conter no máximo 30 caracteres.")
    String name();
    @Length(max = 2000, message = "A descrição deve conter no máximo 2000 caracteres.")
    String description();
    @Positive(message = "O peso deve ser maior que zero.")
    Double weight();
    @Past(message = "Data inválida.")
    LocalDate birth();
    @NotBlank(message = "Deve ser escolhido entre sim ou não.")
    boolean estimatedBirth();
    @NotBlank(message = "Deve ser escolhido entre macho ou fêmea")
    PetGenre genre();
    @NotBlank(message = "Deve ser escolhido um valor válido para castração")
    Castration castration();
    @NotEmpty(message = "Deve haver pelo menos três característica do pet")
    @Size(min = 3, message = "Deve haver pelo menos três características gerais do pet")
    Set<GeneralTraits> generalTraits();
    @NotEmpty(message = "Deve haver pelo menos uma URL válida")
    List< @URL String> photoUrls();
    @Valid
    List<PetVaccineRequest> vaccinations();
}
