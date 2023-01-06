package com.jasonyecyec.springdemo.controller;

import com.jasonyecyec.springdemo.dao.CustomerDAO;
import com.jasonyecyec.springdemo.entity.Customer;
import com.jasonyecyec.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Entity;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //inject the customer DAO
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomer(Model model){
        //get customers from the dao
        List<Customer> customerList = this.customerService.getCustomers();

        //add the customers to model
        model.addAttribute("customers",customerList);
        return "list-customer";
    }

    @GetMapping("/showFormAdd")
    public String showFormAdd(Model model){
        //create model attribute to bind form data
        Customer customer = new Customer();

        model.addAttribute("customer",customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        //save the customer using service
        this.customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }


}
