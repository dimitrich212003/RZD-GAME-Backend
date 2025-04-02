package com.game.rzd.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false)
    private int placeNumber;
    @Column
    private String phoneNumber;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String passportData;

    public User(int placeNumber, String phoneNumber, String firstName, String lastName, String passportData) {
        this.placeNumber = placeNumber;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportData = passportData;
    }

    public User() {

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

    public String getPassportData() {
        return passportData;
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
