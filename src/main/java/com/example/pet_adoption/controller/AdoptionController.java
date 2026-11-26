package com.example.pet_adoption.controller;

import com.example.pet_adoption.domain.accounts.Publisher;
import com.example.pet_adoption.domain.adoption.dto.AdoptionRequest;
import com.example.pet_adoption.domain.adoption.dto.AdoptionResponse;
import com.example.pet_adoption.repository.AdoptionRepository;
import com.example.pet_adoption.service.AdoptionService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
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
            AdoptionService service,
            AdoptionRepository repository) {
        this.adoptionService = service;
        this.adoptionRepository = repository;
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

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<PagedModel<AdoptionResponse>> getAllAdoptions(
            @PageableDefault(size = 30) Pageable pageable
    ){
        Page<AdoptionResponse> page = adoptionRepository
                .findAll(pageable)
                .map(AdoptionResponse::new);
        return ResponseEntity.ok(new PagedModel<>(page));
    }

}
