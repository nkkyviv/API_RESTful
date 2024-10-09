package com.groupone.dao;

import com.groupone.model.Customer;
import com.groupone.service.CustomerService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDao {

    static List<Customer> customers = new ArrayList<Customer>();
    private static int idCounter = 1;

    // Constructor
    public CustomerDao() {
        // Adding a customer directly in the constructor
        Customer cus1 = new Customer("Vivian", "Okafor", "0908356181", "vivian@yahoo.com");
        Customer cus2 = new Customer("kene", "Ezeh", "0805634826", "kene@yahoo.com");
        addCustomer(cus1); // Adds the customer when the object is initialized
        addCustomer(cus2);
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

           return true;

        }
        return false;
    }
}
