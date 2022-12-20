package com.example.readingisgood.controller;

import com.example.readingisgood.model.Customer;
import com.example.readingisgood.model.Orders;
import com.example.readingisgood.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers()
    {
        return customerService.getAllCustomer();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customerRequest)
    {
        Customer customer = customerService.createCustomer(new Customer(customerRequest.getName(), customerRequest.getMail(), customerRequest.getPassword(), customerRequest.getOrders()));
        return customer;
    }

    @GetMapping("/{customerId}/orders")
    public List<Orders> getOrdersByCustomerId(@PathVariable(value = "customerId") Long customerId)
    {
        List<Orders> orders = customerService.getOrdersByCustomerId(customerId);
        return orders;
    }
}
