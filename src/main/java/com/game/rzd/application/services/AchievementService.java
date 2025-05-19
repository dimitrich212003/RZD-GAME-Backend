package com.game.rzd.application.services;

import com.game.rzd.application.services.DTOs.requests.AchievementRequestDTO;
import com.game.rzd.application.services.DTOs.responses.AchievementResponseDTO;

import java.util.List;
import java.util.UUID;

public interface AchievementService {
    List<AchievementResponseDTO> getFoxAchievements(UUID foxId);
    AchievementResponseDTO unlockAchievement(UUID foxId, int code);
    List<AchievementResponseDTO> createAchievements(UUID foxId);
}
