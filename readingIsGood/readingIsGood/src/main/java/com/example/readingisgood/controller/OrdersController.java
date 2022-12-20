package com.example.readingisgood.controller;

import com.example.readingisgood.model.Book;
import com.example.readingisgood.model.Orders;
import com.example.readingisgood.service.BookService;
import com.example.readingisgood.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrdersController
{
    @Autowired
    OrdersService ordersService;

    @Autowired
    BookService bookService;

    @GetMapping
    public List<Orders> getAllOrders()
    {
        return ordersService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<Orders> getOdersById(@PathVariable(value = "id") Long id)
    {
        return ordersService.findOrdersById(id);
    }

    @PostMapping("/{bookId}/orders")
    public Orders createOrders(@PathVariable(value = "bookId") Long bookId, @RequestBody Orders ordersRequest)
    {
        Optional<Book> bookById = bookService.findBookById(bookId);
        bookById.get().addOrdersAndUpdateQuantity(ordersRequest);
        return ordersService.createOrders(new Orders(ordersRequest.getLocalDateTime(), ordersRequest.getNumberOfOrder(), ordersRequest.getBooks()));
    }

    @GetMapping("/{startDate}/{endDate}/betweenDates")
    public List<Orders> getOrdersBetweenDates(@PathVariable(value = "startDate") String startDate, @PathVariable(value = "endDate") String endDate)
    {
        LocalDateTime startLocalDateTime = LocalDateTime.parse(startDate);
        LocalDateTime endLocalDateTime = LocalDateTime.parse(endDate);

        return ordersService.findAllByLocalDateTimeBetween(startLocalDateTime, endLocalDateTime);
    }
}
