package com.game.rzd.mappers.impl;

import com.game.rzd.mappers.RequestMapper;
import com.game.rzd.mappers.ResponseMapper;
import com.game.rzd.models.GameRecord;
import com.game.rzd.models.Fox;
import com.game.rzd.repositories.FoxRepository;
import com.game.rzd.services.DTOs.requests.GameRecordRequestDTO;
import com.game.rzd.services.DTOs.responses.GameRecordResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GameRecordMapper implements RequestMapper<GameRecordRequestDTO, GameRecord>, ResponseMapper<GameRecordResponseDTO, GameRecord> {
    private final ModelMapper modelMapper;
    private final FoxRepository foxRepository;

    @Autowired
    public GameRecordMapper(ModelMapper modelMapper, FoxRepository foxRepository) {
        this.modelMapper = modelMapper;
        this.foxRepository = foxRepository;
    }

    @Override
    public GameRecord toModel(GameRecordRequestDTO request) {
        GameRecord record = modelMapper.map(request, GameRecord.class);

        UUID foxId = request.getFoxId();
        if (foxId != null) {
            Fox fox = foxRepository.findById(foxId)
                    .orElseThrow(() -> new IllegalArgumentException("Fox not found"));
            record.setFox(fox);
        }

        return record;
    }

    @Override
    public GameRecordResponseDTO toResponse(GameRecord model) {
        GameRecordResponseDTO response = modelMapper.map(model, GameRecordResponseDTO.class);
        Fox fox = model.getFox();
        UUID foxId = (fox != null) ? fox.getId() : null;

        return new GameRecordResponseDTO(
                response.id(),
                response.game(),
                response.score(),
                foxId
        );
    }
}
