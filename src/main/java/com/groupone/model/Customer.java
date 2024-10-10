package com.groupone.model;

import java.util.List;

public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private List<String> interestedProperties; // New field

    public Customer(String firstName, String lastName, String phoneNumber, String email, List<String> interestedProperties) {
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.lastName = lastName;
        this.email = email;
        this.interestedProperties = interestedProperties;
    }

    public Customer (int id, String firstName, String lastName, String phoneNumber, String email, List<String> interestedProperties)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.interestedProperties = interestedProperties;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
