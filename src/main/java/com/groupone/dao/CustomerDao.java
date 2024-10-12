package com.groupone.dao;

import com.groupone.model.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CustomerDao {

    static List<Customer> customers = new ArrayList<Customer>();
    private static int idCounter = 1;

    // Constructor
    // Constructor
    public CustomerDao() {
        // Adding sample customers with interested properties
        List<String> vivianProperties = Arrays.asList("Land - Lagos", "Apartment - Abuja");
        List<String> keneProperties = Arrays.asList("Land - Enugu", "Apartment - Port Harcourt");
        List<String> maryProperties = List.of("Land - Abuja");


        Customer cus1 = new Customer("Vivian", "Okafor", "0908356181", "vivian@yahoo.com", vivianProperties);
        Customer cus2 = new Customer("Kene", "Ezeh", "0805634826", "kene@yahoo.com", keneProperties);
        Customer cus3 = new Customer("Mary", "Agbang", "08053177854", "mary@yahoo.com", maryProperties);

        addCustomer(cus1);
        addCustomer(cus2);
        addCustomer(cus3);
    }

    // Method to add a customer
    public boolean addCustomer(Customer customer) {
        if(customer != null)
        {
            customer.setId(idCounter++); // Set an auto-generated ID
            customers.add(customer); // Add customer to the list
        }
        return true;
    }

    public Customer getCustomer(int id)
    {
        return customers.stream().filter(m -> m.getId() == (id)).findAny().orElse(null);
    }

    public List<Customer> getCustomers()
    {
        return customers;
    }

    public boolean updateCustomer(int id, Customer customer) {
        // Find the existing customer using the provided id
        Customer exist = customers.stream()
                .filter(m -> m.getId() == id) // Filter by the provided id
                .findAny()
                .orElse(null); // If not found, return null

        if (exist != null) {
            // Update the fields with new values from the customer object
            System.out.println("Updating customer first name from: " + exist.getFirstName() + " to: " + customer.getFirstName());

            if (customer.getFirstName() != null) {
                exist.setFirstName(customer.getFirstName());
            }

            if (customer.getLastName() != null) {
                exist.setLastName(customer.getLastName());
            }

            if (customer.getPhoneNumber() != null) {
                exist.setPhoneNumber(customer.getPhoneNumber());
            }

            if (customer.getEmail() != null) {
                exist.setEmail(customer.getEmail());
            }

            if (customer.getInterestedProperties() != null) {
                exist.setInterestedProperties(customer.getInterestedProperties());
            }

            return true; // Update was successful
        }

        return false;
    }


    // Delete a customer by ID
    public boolean deleteCustomer(int id) {
        Customer exist = getCustomer(id);
        if (exist != null) {
            customers.remove(exist);
            return true;
        }
        return false;
    }
}
