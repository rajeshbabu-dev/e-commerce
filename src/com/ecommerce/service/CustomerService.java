package com.ecommerce.service;

import com.ecommerce.exeption.CustomerExistException;
import com.ecommerce.exeption.CustomerNotFoundException;
import com.ecommerce.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(int id);

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(int id, Customer customer);

    void deleteCustomer(int id);

}
