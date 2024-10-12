package com.groupone.service;

import com.groupone.contract.CreateCustomerRequest;
import com.groupone.contract.UpdateCustomerRequest;
import com.groupone.dao.CustomerDao;
import com.groupone.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao){
        this.customerDao = customerDao;
    }

    public boolean createCustomer(CreateCustomerRequest request){

        Customer customer = new Customer(request.getFirstName(), request.getLastName(),
                request.getPhoneNumber(), request.getEmail(), request.getInterestedProperties() );
        return customerDao.addCustomer(customer);
    }

    public List<Customer> getCustomers()
    {
        return customerDao.getCustomers();
    }

    public Customer getCustomer(int id){

        return customerDao.getCustomer(id);
    }

    public boolean updateCustomer(int id, UpdateCustomerRequest request){

        Customer customer = new Customer(request.getFirstName(),
                request.getLastName(),
                request.getPhoneNumber(),
                request.getEmail(),
                request.getInterestedProperties());

        return customerDao.updateCustomer(id, customer);
    }

    public boolean deleteCustomer(int id){

        return customerDao.deleteCustomer(id);
    }
}
