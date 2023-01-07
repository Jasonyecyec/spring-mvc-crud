package com.jasonyecyec.springdemo.service;

import com.jasonyecyec.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public Customer getCustomer(int customerId);

    public void saveCustomer(Customer customer);

    public void deleteCustomer(int customerId);

    public List<Customer> searchCustomers(String theSearchName);
}
