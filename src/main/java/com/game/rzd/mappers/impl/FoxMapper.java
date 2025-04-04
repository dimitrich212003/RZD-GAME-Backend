package com.game.rzd.mappers.impl;

import com.game.rzd.mappers.RequestMapper;
import com.game.rzd.mappers.ResponseMapper;
import com.game.rzd.models.Fox;
import com.game.rzd.models.User;
import com.game.rzd.repositories.UserRepository;
import com.game.rzd.services.DTOs.requests.FoxRequestDTO;
import com.game.rzd.services.DTOs.responses.FoxResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;


@Component
public class FoxMapper implements RequestMapper<FoxRequestDTO, Fox>, ResponseMapper<FoxResponseDTO, Fox> {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Autowired
    public FoxMapper(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public Fox toModel(FoxRequestDTO request) {
        Fox fox = modelMapper.map(request, Fox.class);
        UUID userId = request.getUserId();
        if(userId != null) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));
            fox.setUser(user);
        }
        return fox;
    }

    @Override
    public FoxResponseDTO toResponse(Fox model) {
        FoxResponseDTO response = modelMapper.map(model, FoxResponseDTO.class);
        User user = model.getUser();
        UUID userId = (user != null) ? user.getId() : null;

        return new FoxResponseDTO(
                response.id(),
                response.name(),
                response.coins(),
                response.gameLevel(),
                userId
        );
    }
}
