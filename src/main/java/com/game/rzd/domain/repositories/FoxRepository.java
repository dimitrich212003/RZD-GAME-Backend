package com.game.rzd.domain.repositories;

import com.game.rzd.domain.models.Fox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FoxRepository extends JpaRepository<Fox, UUID> {
}
