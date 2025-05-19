package com.game.rzd.presentation;


import com.game.rzd.application.services.DTOs.requests.FoxRequestDTO;
import com.game.rzd.application.services.DTOs.responses.FoxResponseDTO;
import com.game.rzd.application.services.FoxService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/fox")
public class FoxController {

    private final FoxService foxService;

    @Autowired
    public FoxController(FoxService foxService) {
        this.foxService = foxService;
    }

    @GetMapping("/{id}")
    public FoxResponseDTO getFox(@PathVariable UUID id) {
        return foxService.getFoxById(id);
    }

    @PostMapping
    public FoxResponseDTO createFox(@RequestBody @Valid FoxRequestDTO request) {
        return foxService.createFox(request);
    }

    @PutMapping("/updateName/{id}")
    public ResponseEntity<FoxResponseDTO> updateFoxName(@PathVariable UUID id, @RequestBody String foxName) {
        return ResponseEntity.ok(foxService.updateFoxName(id, foxName));
    }

    @PutMapping("/updateGameLevel/{id}")
    public ResponseEntity<FoxResponseDTO> updateGameLevel(@PathVariable UUID id, @RequestBody String gameLevel) {
        return ResponseEntity.ok(foxService.updateGameLevel(id, gameLevel));
    }

    @PutMapping("/addCoins/{id}")
    public FoxResponseDTO addCoins(@PathVariable UUID id, @RequestBody int coins) {
        return foxService.addCoins(id, coins);
    }
}
