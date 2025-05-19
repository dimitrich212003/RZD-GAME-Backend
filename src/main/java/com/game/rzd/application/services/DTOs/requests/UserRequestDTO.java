package com.game.rzd.application.services.DTOs.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {

    @Min(value = 0,message = "Посадочное место не может быть отрицательным")
    @NotBlank(message = "Посадочное место не может быть пустым")
    private int placeNumber;
    @NotBlank(message = "Телефон не может быть пустым")
    @Size(min = 10, max = 12, message = "Телефон должен содержать от 10 до 12 символов")
    @Pattern(regexp = "^[\\d\\+]+$", message = "Телефон должен содержать только цифры, +, -, () и пробелы")
    private String phoneNumber;
    @NotBlank(message = "Имя не может быть пустым")
    @Size(min = 2, max = 20, message = "Имя должно быть от 2 до 20 символов")
    private String firstName;
    @NotBlank(message = "Фамилия не может быть пустой")
    @Size(min = 2, max = 20, message = "Фамилия должна быть от 2 до 20 символов")
    private String lastName;
    @NotBlank(message = "Паспортные данные не могут быть пустыми")
    @Size(min = 10, max = 10, message = "Паспортные данные должны быть длинной 10 символов")
    private String passportData;

    public UserRequestDTO() {
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassportData(String passportData) {
        this.passportData = passportData;
    }
}
