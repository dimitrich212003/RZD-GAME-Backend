package com.game.rzd.domain.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@MappedSuperclass
public class BaseEntity {

    @Id
    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Для немедленного получения ID
    protected UUID id;

    public UUID getId() {
        return id;
    }
}
