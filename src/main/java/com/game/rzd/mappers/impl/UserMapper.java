package com.game.rzd.mappers.impl;

import com.game.rzd.mappers.RequestMapper;
import com.game.rzd.mappers.ResponseMapper;
import com.game.rzd.models.User;
import com.game.rzd.services.DTOs.requests.UserRequestDTO;
import com.game.rzd.services.DTOs.responses.UserResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements RequestMapper<UserRequestDTO, User>, ResponseMapper<UserResponseDTO, User> {

    private final ModelMapper modelMapper;

    @Autowired
    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public User toModel(UserRequestDTO request) {
        User user = modelMapper.map(request, User.class);
        return user;
    }

    @Override
    public UserResponseDTO toResponse(User model) {
        UserResponseDTO userResponseDTO = modelMapper.map(model, UserResponseDTO.class);
        return userResponseDTO;
    }
}
