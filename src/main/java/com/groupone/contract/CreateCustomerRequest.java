package com.groupone.contract;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class CreateCustomerRequest {

    @NotBlank(message = "First name can not be Blank")
    @Size(min = 2, max = 25, message = "First name length must be > 2 and < 25")
    private String firstName;
    @NotBlank(message = "Last name can not be Blank")
    private String lastName;
    @NotBlank(message = "Phone number can not be Blank")
    private String phoneNumber;
    @NotBlank(message = "email can not be Blank")
    private String email;

    private List<String> interestedProperties; // New field

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getInterestedProperties() {
        return interestedProperties;
    }

    public void setInterestedProperties(List<String> interestedProperties) {
        this.interestedProperties = interestedProperties;
    }
}
