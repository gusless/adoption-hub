package com.example.pet_adoption.domain.address.dto;

import com.example.pet_adoption.domain.address.State;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record AddressRequest(
        @NotBlank(message = "Digite um CEP válido")
        @Pattern(regexp = "^\\d{5}-?\\d{3}$", message = "Deve ser inserido um CEP válido sem pontuação")
        String cep,
        @NotBlank()
        @Pattern(regexp = "^[A-Z]{2}$",
                message = "A sigla do estado deve conter uma sigla de um estado brasileiro (ex: RN, SP)")
        State state,
        @NotBlank(message = "Cidade inválida")
        @Length(max = 40,  message = "Deve haver no máximo 40 caracteres")
        String city,
        @NotBlank(message = "Bairro inválido")
        @Length(max = 100,  message = "Deve haver no máximo 100 caracteres")
        String neighborhood,
        @NotBlank(message = "Rua inválida")
        @Length(max = 150,  message = "Deve haver no máximo 150 caracteres")
        String street,
        @Length(max = 20, message = "Deve haver no máximo 20 caracteres")
        String number,
        @Length(max = 150,  message = "Deve haver no máximo 150 caracteres")
        String complement
) {
}
