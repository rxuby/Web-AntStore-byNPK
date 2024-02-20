package com.project.main.service;

import java.util.List;

import com.project.main.entity.Customer;

public interface CustomerService {
    Customer getCustomerById(int customerId);
    List<Customer> getAllCustomers();
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int customerId);
    Customer getCustomerByUsername(String username);
}
