package com.game.rzd.domain.repositories;

import com.game.rzd.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
