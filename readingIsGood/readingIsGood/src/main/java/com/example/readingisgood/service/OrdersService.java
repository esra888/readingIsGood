package com.example.readingisgood.service;

import com.example.readingisgood.model.Customer;
import com.example.readingisgood.model.Orders;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrdersService
{
    Orders createOrders(Orders orders);
    List<Orders> getAllOrders();

    Optional<Orders> findOrdersById(Long ordersId);

    List<Orders> findAllByLocalDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
}
