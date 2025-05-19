package com.game.rzd.application.mappers.impl;

import com.game.rzd.application.mappers.RequestMapper;
import com.game.rzd.application.mappers.ResponseMapper;
import com.game.rzd.domain.models.Fox;
import com.game.rzd.domain.models.User;
import com.game.rzd.domain.repositories.UserRepository;
import com.game.rzd.application.services.DTOs.requests.FoxRequestDTO;
import com.game.rzd.application.services.DTOs.responses.FoxResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        UUID userId = (model.getUser() != null) ? model.getUser().getId() : null;

        return new FoxResponseDTO(
                model.getId(),
                model.getName(),
                model.getCoins(),
                model.getGameLevel(),
                userId
        );
    }
}
