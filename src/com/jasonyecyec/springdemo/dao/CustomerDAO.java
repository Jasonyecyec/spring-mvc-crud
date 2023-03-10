package com.jasonyecyec.springdemo.dao;

import com.jasonyecyec.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {


    public Customer getCustomer(int customerId);

    public List<Customer> getCustomers();


    public void saveCustomer(Customer customer);

    public void deleteCustomer(int customerId);

    public List<Customer> searchCustomers(String theSearchName);
}
