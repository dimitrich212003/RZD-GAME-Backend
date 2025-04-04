package com.game.rzd.repositories;

import com.game.rzd.models.Fox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FoxRepository extends JpaRepository<Fox, UUID> {
}
