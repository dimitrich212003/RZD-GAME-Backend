package com.game.rzd.services.DTOs.responses;

import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        int placeNumber,
        String phoneNumber,
        String firstName,
        String lastName
) {}
