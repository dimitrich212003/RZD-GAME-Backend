package com.game.rzd.mappers.impl;

import com.game.rzd.mappers.RequestMapper;
import com.game.rzd.mappers.ResponseMapper;
import com.game.rzd.models.Achievement;
import com.game.rzd.models.Fox;
import com.game.rzd.repositories.FoxRepository;
import com.game.rzd.services.DTOs.requests.AchievementRequestDTO;
import com.game.rzd.services.DTOs.responses.AchievementResponseDTO;
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
        AchievementResponseDTO response = modelMapper.map(model, AchievementResponseDTO.class);
        Fox fox = model.getFox();
        UUID foxId = (fox != null) ? fox.getId() : null;

        return new AchievementResponseDTO(
                response.id(),
                response.name(),
                response.unlocked(),
                foxId
        );
    }
}
