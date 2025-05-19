package com.game.rzd.application.services.DTOs.responses;

import java.util.UUID;

public class FoxResponseDTO {
    private UUID id;
    private String name;
    private int coins;
    private String gameLevel;
    private UUID userId;

    public FoxResponseDTO(UUID id, String name, int coins, String gameLevel, UUID userId) {
        this.id = id;
        this.name = name;
        this.coins = coins;
        this.gameLevel = gameLevel;
        this.userId = userId;
    }

    public FoxResponseDTO() {
    }

    public UUID getId() {
        return id;
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
}