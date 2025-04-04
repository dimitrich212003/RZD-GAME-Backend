package com.game.rzd.services.DTOs.requests;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class AchievementRequestDTO {
    @NotBlank(message = "Имя достижения не может быть пустым")
    private String name;
    private boolean unlocked;
    private UUID foxId;

    public AchievementRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public UUID getFoxId() {
        return foxId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public void setFoxId(UUID foxId) {
        this.foxId = foxId;
    }
}
