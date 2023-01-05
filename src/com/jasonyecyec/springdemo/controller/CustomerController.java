package com.jasonyecyec.springdemo.controller;

import com.jasonyecyec.springdemo.dao.CustomerDAO;
import com.jasonyecyec.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Entity;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //inject the customer DAO
    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomer(Model model){
        //get customers from the dao
        List<Customer> customerList = this.customerDAO.getCustomers();

        //add the customers to model
        model.addAttribute("customers",customerList);
        return "list-customer";
    }

}
