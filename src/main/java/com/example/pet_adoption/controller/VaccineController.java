package com.example.pet_adoption.controller;

import com.example.pet_adoption.domain.vaccine.Vaccine;
import com.example.pet_adoption.domain.vaccine.dto.DtoNewVaccine;
import com.example.pet_adoption.domain.vaccine.dto.DtoOutVaccine;
import com.example.pet_adoption.domain.vaccine.dto.DtoUpdateVaccine;
import com.example.pet_adoption.repository.VaccineRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public ResponseEntity<DtoOutVaccine> addVaccine(@Valid @RequestBody DtoNewVaccine newVaccine){
        Vaccine vaccine = new Vaccine(newVaccine);
        repository.save(vaccine);
        return ResponseEntity.ok(new DtoOutVaccine(vaccine));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoOutVaccine> getVaccine(@PathVariable Long id){
        Vaccine vaccine = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(new DtoOutVaccine(vaccine));
    }

    @GetMapping
    public ResponseEntity<PagedModel<DtoOutVaccine>> getAllVaccines(
            @PageableDefault(size = 20) Pageable pageable
            ){
        Page<DtoOutVaccine> vaccinePage = repository
                .findAll(pageable)
                .map(DtoOutVaccine::new);
        return ResponseEntity.ok(new PagedModel<>(vaccinePage));
    }

    @PutMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DtoOutVaccine> updateVaccine(
            @PathVariable Long id,
            @Valid @RequestBody DtoUpdateVaccine vaccineUpdated
    ) {
        Vaccine vaccine = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        vaccine.updateInfos(vaccineUpdated);

        return ResponseEntity.ok(new DtoOutVaccine(vaccine));
    }

}
