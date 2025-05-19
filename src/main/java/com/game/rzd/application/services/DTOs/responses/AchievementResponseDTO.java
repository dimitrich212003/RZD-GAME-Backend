package com.game.rzd.application.services.DTOs.responses;

import java.util.UUID;

public class AchievementResponseDTO {
    private UUID id;
    private int code;
    private boolean unlocked;
    private UUID foxId;

    public AchievementResponseDTO(UUID id, int code, boolean unlocked, UUID foxId) {
        this.id = id;
        this.code = code;
        this.unlocked = unlocked;
        this.foxId = foxId;
    }

    public AchievementResponseDTO() {
    }

    public UUID getId() {
        return id;
    }

    public int getCode() {
        return code;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public UUID getFoxId() {
        return foxId;
    }
}
