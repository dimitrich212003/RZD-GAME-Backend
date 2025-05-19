package com.game.rzd.application.services.DTOs.responses;

import java.util.UUID;

public class UserResponseDTO {
    private UUID id;
    private int placeNumber;
    private String phoneNumber;
    private String firstName;
    private String lastName;

    public UserResponseDTO(UUID id, int placeNumber, String phoneNumber, String firstName, String lastName) {
        this.id = id;
        this.placeNumber = placeNumber;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserResponseDTO() {
    }

    public UUID getId() {
        return id;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
