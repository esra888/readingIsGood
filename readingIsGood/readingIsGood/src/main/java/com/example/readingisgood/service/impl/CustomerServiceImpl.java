package com.example.readingisgood.service.impl;

import com.example.readingisgood.model.Customer;
import com.example.readingisgood.model.Orders;
import com.example.readingisgood.repository.CustomerRepository;
import com.example.readingisgood.repository.OrdersRepository;
import com.example.readingisgood.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public Customer createCustomer(Customer customer)
    {
        List<Orders> orders = customer.getOrders();
        for (Orders ordersList: orders)
        {
            if(ordersList.getNumberOfOrder() <= 0){
                throw new NoSuchElementException();
            }
        }
        if(customerRepository.findCustomersByMail(customer.getMail()) != null)
        {
            throw new NoSuchElementException();
        }
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer()
    {
        return customerRepository.findAll();
    }

    @Override
    public List<Orders> getOrdersByCustomerId(Long customerId)
    {
        return ordersRepository.findOrdersByCustomerId(customerId);
    }

    @Override
    public Optional<Customer> findCustomerById(Long customerId)
    {
        return customerRepository.findById(customerId);
    }

}
