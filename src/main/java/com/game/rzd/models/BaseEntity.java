package com.game.rzd.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@MappedSuperclass
public class BaseEntity {

    @Id
    @UuidGenerator
    protected UUID id;

    public UUID getId() {
        return id;
    }
}
