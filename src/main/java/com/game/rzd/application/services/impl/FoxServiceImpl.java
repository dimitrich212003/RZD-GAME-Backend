package com.game.rzd.application.services.impl;

import com.game.rzd.application.mappers.impl.FoxMapper;
import com.game.rzd.application.services.GameRecordService;
import com.game.rzd.domain.models.Fox;
import com.game.rzd.domain.repositories.FoxRepository;
import com.game.rzd.application.services.AchievementService;
import com.game.rzd.application.services.DTOs.requests.FoxRequestDTO;
import com.game.rzd.application.services.DTOs.responses.FoxResponseDTO;
import com.game.rzd.application.services.FoxService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ConcurrentModificationException;
import java.util.UUID;

@Service
public class FoxServiceImpl implements FoxService {

    private final int INITIAL_COINS = 0;


    private final FoxRepository foxRepository;
    private final FoxMapper foxMapper;
    private final AchievementService achievementService;
    private final GameRecordService gameRecordService;

    @Autowired
    public FoxServiceImpl(FoxRepository foxRepository, FoxMapper foxMapper, AchievementService achievementService, GameRecordService gameRecordService) {
        this.foxRepository = foxRepository;
        this.foxMapper = foxMapper;
        this.achievementService = achievementService;
        this.gameRecordService = gameRecordService;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public FoxResponseDTO createFox(FoxRequestDTO requestDTO) {
        Fox fox = foxMapper.toModel(requestDTO);
        fox.setCoins(INITIAL_COINS);
        Fox savedFox = foxRepository.saveAndFlush(fox);
        achievementService.createAchievements(savedFox.getId());
        gameRecordService.createRecords(savedFox.getId());
        return foxMapper.toResponse(savedFox);
    }

    @Override
    @Transactional
    public FoxResponseDTO updateFoxName(UUID id, String foxName) {
        Fox fox = foxRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("fox not found"));
        fox.setName(foxName);
        Fox savedFox = foxRepository.save(fox);
        return foxMapper.toResponse(savedFox);
    }

    @Override
    @Transactional
    public FoxResponseDTO updateGameLevel(UUID id, String gameLevel) {
        Fox fox = foxRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("fox not found"));
        fox.setGameLevel(gameLevel);
        Fox savedFox = foxRepository.save(fox);
        return foxMapper.toResponse(savedFox);
    }

    @Override
    @Transactional
    public FoxResponseDTO addCoins(UUID id, int coins) {
        System.out.println("Adding coins: foxId= "+ id + ", coins= " + coins);
        try {
            if (coins <= 0) {
                throw new IllegalArgumentException("Coins must be positive");
            }
            Fox fox = foxRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("fox not found"));
            fox.setCoins(fox.getCoins() + coins);
            Fox savedFox = foxRepository.save(fox);
            return foxMapper.toResponse(savedFox);
        }
        catch (ObjectOptimisticLockingFailureException e) {
            throw new ConcurrentModificationException("Fox was modified by another transaction. Try again.");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public FoxResponseDTO getFoxById(UUID id) {
        Fox fox = foxRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("fox not found"));
        return foxMapper.toResponse(fox);
    }
}
