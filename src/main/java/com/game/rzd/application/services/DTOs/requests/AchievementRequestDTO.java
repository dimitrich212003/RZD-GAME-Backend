package com.game.rzd.application.services.DTOs.requests;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class AchievementRequestDTO {
    @NotBlank(message = "Имя достижения не может быть пустым")
    private int code;
    private boolean unlocked;
    private UUID foxId;

    public AchievementRequestDTO() {
    }

    public AchievementRequestDTO(int code, boolean unlocked, UUID foxId) {
        this.code = code;
        this.unlocked = unlocked;
        this.foxId = foxId;
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

    public void setCode(int name) {
        this.code = code;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public void setFoxId(UUID foxId) {
        this.foxId = foxId;
    }
}
