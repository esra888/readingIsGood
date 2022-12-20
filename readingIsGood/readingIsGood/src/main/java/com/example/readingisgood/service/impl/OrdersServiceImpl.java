package com.example.readingisgood.service.impl;

import com.example.readingisgood.model.Orders;
import com.example.readingisgood.repository.OrdersRepository;
import com.example.readingisgood.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService
{
    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public Orders createOrders(Orders orders)
    {
        return ordersRepository.save(orders);
    }

    @Override
    public List<Orders> getAllOrders()
    {
        return ordersRepository.findAll();
    }

    @Override
    public Optional<Orders> findOrdersById(Long ordersId)
    {
        return ordersRepository.findById(ordersId);
    }

    @Override
    public List<Orders> findAllByLocalDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate)
    {
        return ordersRepository.findAllByLocalDateTimeBetween(startDate, endDate);
    }
}
