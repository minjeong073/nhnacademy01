package com.nhnacademy.edu.springframework;

public class User {
    private final String name;
    private final String email;
    private final String phoneNumber;

    public User(String email, String phoneNumber) {

        name = null;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
