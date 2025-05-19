package com.game.rzd.application.services.DTOs.requests;

import com.game.rzd.domain.models.Game;
import jakarta.validation.constraints.Min;

import java.util.UUID;

public class GameRecordRequestDTO {
    private Game game;
    @Min(value = 0, message = "Количество монет не может быть отрицательным")
    private int score;
    private UUID foxId;

    public GameRecordRequestDTO() {
    }

    public GameRecordRequestDTO(Game game, int score, UUID foxId) {
        this.game = game;
        this.score = score;
        this.foxId = foxId;
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

    public void setGame(Game game) {
        this.game = game;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setFoxId(UUID foxId) {
        this.foxId = foxId;
    }
}
