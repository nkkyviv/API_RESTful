package com.groupone.contract;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class DeleteCustomer {

    @NotBlank(message = "First name can not be Blank")
    private String firstName;
    @NotBlank(message = "Last name can not be Blank")
    private String lastName;
    @NotBlank(message = "Phone Number can not be Blank")
    private String phoneNumber;
    @NotBlank(message = "email can not be Blank")
    private String email;

    private List<String> interestedProperties;

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
