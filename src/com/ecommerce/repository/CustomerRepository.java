package com.ecommerce.repository;

import com.ecommerce.model.Customer;
import com.ecommerce.util.CsvParser;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private final List<Customer> customers;

    public CustomerRepository()throws IOException {
        CsvParser csvParser = new CsvParser();
        this.customers = csvParser.getCustomersFromCsv();
    }

//    save customer / create
    public  Customer save(Customer customer) {
        this.customers.add(customer);
        return customer;
    }

//    save All
    public List<Customer> getAll() {
        return customers;
    }
//    Read customer / get customer
    public  Optional<Customer> getById(int id) {
        return customers.stream()
                .filter(customer -> customer.getId() == id)
                .findFirst();
    }

//    update
    public Customer update(int id, Customer customer) {
        this.customers.replaceAll(c -> c.getId() == id ? customer : c );
        return customer;

    }
//    Delete
    public boolean delete(int id) {
        this.customers.removeIf(customer -> customer.getId() == id);
        return true;
    }
}
