package com.game.rzd.application.services;

import com.game.rzd.application.services.DTOs.requests.UserRequestDTO;
import com.game.rzd.application.services.DTOs.responses.UserResponseDTO;

import java.util.UUID;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userDTO);
    UserResponseDTO updateUser(UUID id, UserRequestDTO userDTO);
    void deleteUser(UUID id);
    UserResponseDTO getUserById(UUID id);
}
