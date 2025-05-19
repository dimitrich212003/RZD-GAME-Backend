package com.game.rzd.application.services.DTOs.responses;

import com.game.rzd.domain.models.Game;

import java.util.UUID;

public class GameRecordResponseDTO {
    private UUID id;
    private Game game;
    private int score;
    private UUID foxId;

    public GameRecordResponseDTO(UUID id, Game game, int score, UUID foxId) {
        this.id = id;
        this.game = game;
        this.score = score;
        this.foxId = foxId;
    }

    public GameRecordResponseDTO() {
    }

    public UUID getId() {
        return id;
    }

    public Game getGame() {
        return game;
    }

    public int getScore() {
        return score;
    }

    public UUID getFoxId() {
        return foxId;
    }
}

