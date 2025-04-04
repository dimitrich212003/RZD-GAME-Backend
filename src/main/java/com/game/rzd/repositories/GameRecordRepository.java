package com.game.rzd.repositories;

import com.game.rzd.models.GameRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameRecordRepository extends JpaRepository<GameRecord, UUID> {
}
