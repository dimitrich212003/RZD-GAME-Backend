package com.game.rzd.application.services.impl;

import com.game.rzd.application.mappers.impl.AchievementMapper;
import com.game.rzd.domain.models.Achievement;
import com.game.rzd.domain.models.Fox;
import com.game.rzd.domain.repositories.AchievementRepository;
import com.game.rzd.domain.repositories.FoxRepository;
import com.game.rzd.application.services.AchievementService;
import com.game.rzd.application.services.DTOs.requests.AchievementRequestDTO;
import com.game.rzd.application.services.DTOs.responses.AchievementResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AchievementServiceImpl implements AchievementService {

    private final AchievementRepository achievementRepository;
    private final FoxRepository foxRepository;
    private final AchievementMapper achievementMapper;
    private final int ACHIEVEMENTS_QUANTITY = 8;


    @Autowired
    public AchievementServiceImpl(AchievementRepository achievementRepository, FoxRepository foxRepository, AchievementMapper achievementMapper) {
        this.achievementRepository = achievementRepository;
        this.foxRepository = foxRepository;
        this.achievementMapper = achievementMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AchievementResponseDTO> getFoxAchievements(UUID foxId) {
        Fox fox = foxRepository.findById(foxId).orElseThrow(() -> new EntityNotFoundException("fox not found"));
        List<Achievement> achievements = achievementRepository.findAchievementsByFox(fox).orElseThrow(() -> new EntityNotFoundException("Achievements not found"));

        List<AchievementResponseDTO> response = achievements.stream()
                .map(achievement -> achievementMapper.toResponse(achievement)).collect(Collectors.toList());
        return response;
    }

    @Override
    @Transactional
    public AchievementResponseDTO unlockAchievement(UUID foxId, int code) {
        Fox fox = foxRepository.findById(foxId).orElseThrow(() -> new EntityNotFoundException("fox not found"));

        Achievement achievement = achievementRepository.findAchievementByFoxAndCode(fox, code).orElseThrow(() -> new EntityNotFoundException("Achievement not found"));

        if (!achievement.isUnlocked()) {
            achievement.setUnlocked(true);
        }

        return achievementMapper.toResponse(achievement);
    }

    @Override
    @Transactional
    public List<AchievementResponseDTO> createAchievements(UUID foxId) {
        List<AchievementRequestDTO> foxAchievements = new ArrayList<>();
        for(int i = 0; i < ACHIEVEMENTS_QUANTITY; i++) {
            foxAchievements.add(
                    new AchievementRequestDTO(i + 1, false, foxId)
            );
        }
        List<Achievement> achievements = foxAchievements.stream()
                .map(achievement -> achievementMapper.toModel(achievement)).collect(Collectors.toList());
        List<Achievement> savedAchievements = achievementRepository.saveAll(achievements);
        return savedAchievements.stream()
                .map(achievement -> achievementMapper.toResponse(achievement))
                .collect(Collectors.toList());
    }
}
