package com.example.readingisgood.service;

import com.example.readingisgood.model.Customer;
import com.example.readingisgood.model.Orders;

import java.util.List;
import java.util.Optional;

public interface CustomerService
{
    Customer createCustomer(Customer customer);

    List<Customer> getAllCustomer();

    List<Orders> getOrdersByCustomerId(Long customerId);

    Optional<Customer> findCustomerById(Long customerId);
}
