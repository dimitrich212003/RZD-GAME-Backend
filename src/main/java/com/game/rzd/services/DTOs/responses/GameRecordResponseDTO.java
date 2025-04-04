package com.game.rzd.services.DTOs.responses;

import com.game.rzd.models.Game;

import java.util.UUID;

public record GameRecordResponseDTO(
        UUID id,
        Game game,
        int score,
        UUID foxId
) {}
