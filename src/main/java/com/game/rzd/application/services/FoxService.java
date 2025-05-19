package com.game.rzd.application.services;

import com.game.rzd.application.services.DTOs.requests.FoxRequestDTO;
import com.game.rzd.application.services.DTOs.responses.FoxResponseDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface FoxService {
    FoxResponseDTO createFox(FoxRequestDTO requestDTO);
    FoxResponseDTO updateFoxName(UUID id, String foxName);
    FoxResponseDTO updateGameLevel(UUID id, String gameLevel);
    FoxResponseDTO addCoins(UUID id, int coins);
    FoxResponseDTO getFoxById(UUID id);
}
