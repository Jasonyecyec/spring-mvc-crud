package com.jasonyecyec.springdemo.controller;

import com.jasonyecyec.springdemo.dao.CustomerDAO;
import com.jasonyecyec.springdemo.entity.Customer;
import com.jasonyecyec.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@RequestParam("customerId") int customerId, Model model){
        //get the customer from the service
        Customer customer = this.customerService.getCustomer(customerId);

        //set customer as a model attribute to pre-populate the form
        model.addAttribute("customer", customer);

        //send over to our form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int customerId){
        //delete customer
        this.customerService.deleteCustomer(customerId);
        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                  Model theModel) {
        // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);
        return "list-customer";
    }

}
