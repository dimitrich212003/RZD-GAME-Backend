package com.game.rzd.services.DTOs.responses;

import java.util.UUID;

public record AchievementResponseDTO(
        UUID id,
        String name,
        boolean unlocked,
        UUID foxId
) {}
