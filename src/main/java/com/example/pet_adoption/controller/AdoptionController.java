package com.example.pet_adoption.controller;

import com.example.pet_adoption.domain.accounts.Publisher;
import com.example.pet_adoption.domain.adoption.dto.AdoptionRequest;
import com.example.pet_adoption.domain.adoption.dto.AdoptionResponse;
import com.example.pet_adoption.repository.AdoptionRepository;
import com.example.pet_adoption.service.AdoptionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/adoptions")
public class AdoptionController {

    private final AdoptionService adoptionService;
    private final AdoptionRepository adoptionRepository;

    public AdoptionController(
            AdoptionService adoptionService,
            AdoptionRepository adoptionRepository) {
        this.adoptionService = adoptionService;
        this.adoptionRepository = adoptionRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AdoptionResponse> addAdoption(
            @Valid @RequestBody AdoptionRequest newAdoption,
            @AuthenticationPrincipal Publisher publisher,
            UriComponentsBuilder uriBuilder){

        AdoptionResponse response = adoptionService.create(newAdoption, publisher.getId());
        URI uri = uriBuilder.path("/adoptions/{id}").buildAndExpand(response.id()).toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<AdoptionResponse> getAdoption(@PathVariable Long id){
        AdoptionResponse response = new AdoptionResponse(
                adoptionRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
        );
        return ResponseEntity.ok(response);
    }
}
