package com.jasonyecyec.springdemo.service;

import com.jasonyecyec.springdemo.dao.CustomerDAO;
import com.jasonyecyec.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    //inject customer dao
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }
    @Override
    @Transactional
    public Customer getCustomer(int customerId) {
        return this.customerDAO.getCustomer(customerId);
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        this.customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(int customerId) {
        this.customerDAO.deleteCustomer(customerId);
    }

    @Override
    @Transactional
    public List<Customer> searchCustomers(String theSearchName) {
        return customerDAO.searchCustomers(theSearchName);
    }


}
