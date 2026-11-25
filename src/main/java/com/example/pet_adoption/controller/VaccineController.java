package com.example.pet_adoption.controller;

import com.example.pet_adoption.domain.vaccine.Vaccine;
import com.example.pet_adoption.domain.vaccine.dto.VaccineRequest;
import com.example.pet_adoption.domain.vaccine.dto.VaccineResponse;
import com.example.pet_adoption.domain.vaccine.dto.VaccineUpdateRequest;
import com.example.pet_adoption.repository.VaccineRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/vaccines")
public class VaccineController {

    private final VaccineRepository repository;

    public VaccineController(VaccineRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<VaccineResponse> addVaccine(
            @Valid @RequestBody VaccineRequest newVaccine,
            UriComponentsBuilder uriBuilder
    ){
        Vaccine vaccine = new Vaccine(newVaccine);
        repository.save(vaccine);

        VaccineResponse response = new VaccineResponse(vaccine);
        URI uri = uriBuilder.path("/vaccines/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<VaccineResponse> getVaccine(@PathVariable Long id){
        Vaccine vaccine = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(new VaccineResponse(vaccine));
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<PagedModel<VaccineResponse>> getAllVaccines(
            @PageableDefault(size = 20) Pageable pageable
            ){
        Page<VaccineResponse> vaccinePage = repository
                .findAll(pageable)
                .map(VaccineResponse::new);
        return ResponseEntity.ok(new PagedModel<>(vaccinePage));
    }

    @PutMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<VaccineResponse> updateVaccine(
            @PathVariable Long id,
            @Valid @RequestBody VaccineUpdateRequest vaccineUpdated
    ) {
        Vaccine vaccine = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        vaccine.updateInfos(vaccineUpdated);

        return ResponseEntity.ok(new VaccineResponse(vaccine));
    }

}
