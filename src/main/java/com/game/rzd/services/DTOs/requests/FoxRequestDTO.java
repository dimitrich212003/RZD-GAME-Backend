package com.game.rzd.services.DTOs.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class FoxRequestDTO {
    @NotBlank(message = "Имя не может быть пустым")
    @Size(min = 2, max = 12, message = "Имя должно быть от 2 до 12 символов")
    private String name;
    @Min(value = 0, message = "Количество монет не может быть отрицательным")
    private int coins;
    private String gameLevel;
    private UUID userId;

    public FoxRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public int getCoins() {
        return coins;
    }

    public String getGameLevel() {
        return gameLevel;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void setGameLevel(String gameLevel) {
        this.gameLevel = gameLevel;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
