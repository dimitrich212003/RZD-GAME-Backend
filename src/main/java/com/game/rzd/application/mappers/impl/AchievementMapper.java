package com.game.rzd.application.mappers.impl;

import com.game.rzd.application.mappers.RequestMapper;
import com.game.rzd.application.mappers.ResponseMapper;
import com.game.rzd.domain.models.Achievement;
import com.game.rzd.domain.models.Fox;
import com.game.rzd.domain.repositories.FoxRepository;
import com.game.rzd.application.services.DTOs.requests.AchievementRequestDTO;
import com.game.rzd.application.services.DTOs.responses.AchievementResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AchievementMapper implements RequestMapper<AchievementRequestDTO, Achievement>, ResponseMapper<AchievementResponseDTO, Achievement> {

    private final ModelMapper modelMapper;
    private final FoxRepository foxRepository;

    @Autowired
    public AchievementMapper(ModelMapper modelMapper, FoxRepository foxRepository) {
        this.modelMapper = modelMapper;
        this.foxRepository = foxRepository;
    }

    @Override
    public Achievement toModel(AchievementRequestDTO request) {
        Achievement achievement = modelMapper.map(request, Achievement.class);
        UUID foxId = request.getFoxId();
        if (foxId != null) {
            Fox fox = foxRepository.findById(foxId).orElseThrow(() -> new IllegalArgumentException("fox not found"));
            achievement.setFox(fox);
        }
        return achievement;
    }

    @Override
    public AchievementResponseDTO toResponse(Achievement model) {
        UUID foxId = (model.getFox() != null) ? model.getFox().getId() : null;

        return new AchievementResponseDTO(
                model.getId(),
                model.getCode(),
                model.isUnlocked(),
                foxId
        );
    }
}
