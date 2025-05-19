package com.game.rzd.domain.repositories;

import com.game.rzd.domain.models.Fox;
import com.game.rzd.domain.models.Game;
import com.game.rzd.domain.models.GameRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GameRecordRepository extends JpaRepository<GameRecord, UUID> {
    Optional<GameRecord> findGameRecordByFoxAndGame(Fox fox, Game game);

}
