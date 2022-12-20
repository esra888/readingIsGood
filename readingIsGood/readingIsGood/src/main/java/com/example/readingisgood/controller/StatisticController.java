package com.example.readingisgood.controller;

import com.example.readingisgood.model.Customer;
import com.example.readingisgood.model.Statistic;
import com.example.readingisgood.model.StatisticDetails;
import com.example.readingisgood.repository.OrdersRepository;
import com.example.readingisgood.service.CustomerService;
import com.example.readingisgood.service.OrdersService;
import com.example.readingisgood.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/statistics")
public class StatisticController
{
    @Autowired
    CustomerService customerService;

    @Autowired
    StatisticService statisticService;

    @Autowired
    OrdersService ordersService;

    @Autowired
    OrdersRepository ordersRepository;


    @PostMapping("/customers/{customerId}/statistics")
    public Statistic createStatistics(@PathVariable(value = "customerId") Long customerId,
                                      @RequestBody Statistic statistic)
    {
        Optional<Customer> customer = customerService.findCustomerById(customerId);

        statistic.setCustomer(customer);
        return statisticService.createStatistic(statistic);
    }

    /*@GetMapping({ "/customer/{customerId}"})
    public List<StatisticDetails> getStatisticDetailsById(@PathVariable(value = "customerId") Long customerId) {
        List<StatisticDetails> statisticDetails = new ArrayList<>();
        List<Orders> orders = customerService.getOrdersByCustomerId(customerId);

    }*/

}
