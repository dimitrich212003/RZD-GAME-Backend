package com.game.rzd.services.DTOs.requests;

import com.game.rzd.models.Game;
import jakarta.validation.constraints.Min;

import java.util.UUID;

public class GameRecordRequestDTO {
    private Game game;
    @Min(value = 0, message = "Количество монет не может быть отрицательным")
    private int score;
    private UUID foxId;

    public GameRecordRequestDTO() {
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
