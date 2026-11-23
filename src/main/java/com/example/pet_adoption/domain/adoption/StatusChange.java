package com.example.pet_adoption.domain.adoption;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

@Embeddable
public class StatusChange {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AdoptionStatus status;

    @Column(nullable = false)
    private LocalDateTime changedAt;

    protected StatusChange(){}

    public StatusChange(AdoptionStatus status){
        this.status = status;
        this.changedAt = LocalDateTime.now();
    }

    public AdoptionStatus getStatus() {
        return status;
    }

    public LocalDateTime getChangedAt() {
        return changedAt;
    }
}
