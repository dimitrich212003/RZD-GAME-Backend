package com.game.rzd.domain.repositories;

import com.game.rzd.domain.models.Achievement;
import com.game.rzd.domain.models.Fox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AchievementRepository extends JpaRepository<Achievement, UUID> {
    Optional<Achievement> findAchievementByFoxAndCode(Fox fox, int code);
    Optional<List<Achievement>> findAchievementsByFox(Fox fox);
}
