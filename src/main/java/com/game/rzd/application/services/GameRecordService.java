package com.game.rzd.application.services;

import com.game.rzd.application.services.DTOs.requests.GameRecordRequestDTO;
import com.game.rzd.application.services.DTOs.responses.GameRecordResponseDTO;
import com.game.rzd.domain.models.Game;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public interface GameRecordService {
    List<GameRecordResponseDTO> createRecords(UUID foxId);

    GameRecordResponseDTO updateRecord(UUID foxId, GameRecordRequestDTO requestDTO);

    GameRecordResponseDTO getRecord(UUID foxId, Game game);

}
