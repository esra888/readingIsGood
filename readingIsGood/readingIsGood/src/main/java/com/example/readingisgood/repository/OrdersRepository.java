package com.example.readingisgood.repository;

import com.example.readingisgood.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>
{
    List<Orders> findOrdersByCustomerId(Long customerId);
    List<Orders> findAllByLocalDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
}
