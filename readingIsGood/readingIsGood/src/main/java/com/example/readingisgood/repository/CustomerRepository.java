package com.example.readingisgood.repository;

import com.example.readingisgood.model.Customer;
import com.example.readingisgood.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>
{
    Customer findCustomerByOrdersId(Long ordersId);

    Customer findCustomersByMail(String customerMail);
}
