package com.game.rzd.application.services.impl;

import com.game.rzd.application.mappers.impl.GameRecordMapper;
import com.game.rzd.application.services.DTOs.requests.GameRecordRequestDTO;
import com.game.rzd.application.services.DTOs.responses.GameRecordResponseDTO;
import com.game.rzd.application.services.GameRecordService;
import com.game.rzd.domain.models.Fox;
import com.game.rzd.domain.models.Game;
import com.game.rzd.domain.models.GameRecord;
import com.game.rzd.domain.repositories.FoxRepository;
import com.game.rzd.domain.repositories.GameRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GameRecordServiceImpl implements GameRecordService {

    private final GameRecordRepository gameRecordRepository;
    private final FoxRepository foxRepository;
    private final GameRecordMapper gameRecordMapper;
    private final int INITIAL_RECORD = 0;

    @Autowired
    public GameRecordServiceImpl(GameRecordRepository gameRecordRepository, FoxRepository foxRepository, GameRecordMapper gameRecordMapper) {
        this.gameRecordRepository = gameRecordRepository;
        this.foxRepository = foxRepository;
        this.gameRecordMapper = gameRecordMapper;
    }

    @Override
    @Transactional
    public List<GameRecordResponseDTO> createRecords(UUID foxId) {
        List<GameRecordRequestDTO> recordsRequests = new ArrayList<>();
        for (Game game : Game.values()) {
            recordsRequests.add(
                    new GameRecordRequestDTO(game, INITIAL_RECORD, foxId)
            );
        }
        List<GameRecord> records = recordsRequests.stream()
                .map(recordRequest -> gameRecordMapper.toModel(recordRequest))
                .collect(Collectors.toList());
        gameRecordRepository.saveAll(records);

        return records.stream()
                .map(record -> gameRecordMapper.toResponse(record))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    @CacheEvict(value = "foxes", key = "#foxId")
    public GameRecordResponseDTO updateRecord(UUID foxId, GameRecordRequestDTO requestDTO) {
        Fox fox = foxRepository.findById(foxId).orElseThrow(() -> new IllegalArgumentException("Fox not found " + foxId));
        GameRecord record = gameRecordRepository.findGameRecordByFoxAndGame(fox, requestDTO.getGame()).orElseThrow(() -> new IllegalArgumentException("record not found " + foxId + " " + requestDTO.getGame().name()));
        record.setScore(requestDTO.getScore());
        GameRecord updateRecord = gameRecordRepository.save(record);
        return gameRecordMapper.toResponse(updateRecord);
    }

    @Override
    @Transactional
    @Cacheable(value = "foxes", key = "#foxId")
    public GameRecordResponseDTO getRecord(UUID foxId, Game game) {
        Fox fox = foxRepository.findById(foxId).orElseThrow(() -> new IllegalArgumentException("Fox not found " + foxId));
        GameRecord record = gameRecordRepository.findGameRecordByFoxAndGame(fox, game).orElseThrow(() -> new IllegalArgumentException("record not found " + foxId + " " + game.name()));
        return gameRecordMapper.toResponse(record);
    }

}
