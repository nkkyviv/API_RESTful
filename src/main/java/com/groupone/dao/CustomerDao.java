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

    public boolean updateCustomer(int id, Customer customer)
    {
//        Customer exist = customers.stream()
//                .filter(m -> m.getId() == (customer.getId()))
//                .findAny().orElse(null);

        Customer exist = getCustomer(id);
        if (exist != null)
        {
           exist.setFirstName(customer.getFirstName());
           exist.setLastName(customer.getLastName());
           exist.setPhoneNumber(customer.getPhoneNumber());
           exist.setEmail(customer.getEmail());
           exist.setInterestedProperties(customer.getInterestedProperties());

           return true;

        }
        return false;
    }
}
