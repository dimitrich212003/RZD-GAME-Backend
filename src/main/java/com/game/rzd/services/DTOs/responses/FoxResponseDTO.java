package com.game.rzd.services.DTOs.responses;

import java.util.UUID;

public record FoxResponseDTO(
        UUID id,
        String name,
        int coins,
        String gameLevel,
        UUID userId
) {}
