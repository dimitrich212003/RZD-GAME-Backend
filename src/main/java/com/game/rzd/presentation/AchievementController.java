package com.game.rzd.presentation;

import com.game.rzd.application.services.AchievementService;
import com.game.rzd.application.services.DTOs.responses.AchievementResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/achievement")
public class AchievementController {

    private final AchievementService achievementService;

    @Autowired
    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @GetMapping("/{foxId}")
    List<AchievementResponseDTO> getFoxAchievements(@PathVariable UUID foxId) {
        return achievementService.getFoxAchievements(foxId);
    }

    @PutMapping("/{foxId}/unlock")
    public AchievementResponseDTO unlockAchievement(@PathVariable UUID foxId, @RequestBody int code) {
        return achievementService.unlockAchievement(foxId, code);
    }
}
