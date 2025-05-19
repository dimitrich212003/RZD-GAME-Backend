package com.game.rzd.presentation;

import com.game.rzd.application.services.DTOs.requests.FoxRequestDTO;
import com.game.rzd.application.services.DTOs.requests.GameRecordRequestDTO;
import com.game.rzd.application.services.DTOs.responses.GameRecordResponseDTO;
import com.game.rzd.application.services.GameRecordService;
import com.game.rzd.domain.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/record")
public class GameRecordController {

    private final GameRecordService gameRecordService;

    @Autowired
    public GameRecordController(GameRecordService gameRecordService) {
        this.gameRecordService = gameRecordService;
    }

    @PutMapping("/{foxId}")
    ResponseEntity<GameRecordResponseDTO> updateRecord(@PathVariable UUID foxId, @RequestBody GameRecordRequestDTO requestDTO) {
        return ResponseEntity.ok(gameRecordService.updateRecord(foxId, requestDTO));
    }

    @GetMapping("/{foxId}/{game}")
    public ResponseEntity<GameRecordResponseDTO> getRecord(@PathVariable UUID foxId, @PathVariable Game game) {
        return ResponseEntity.ok(gameRecordService.getRecord(foxId, game));
    }
}
