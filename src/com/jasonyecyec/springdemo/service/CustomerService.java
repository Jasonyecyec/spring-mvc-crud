package com.jasonyecyec.springdemo.service;

import com.jasonyecyec.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);
}
