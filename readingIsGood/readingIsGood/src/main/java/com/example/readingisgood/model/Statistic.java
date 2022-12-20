package com.example.readingisgood.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Optional;

@Data
@Entity
@Table(name = "Statistic")
public class Statistic
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "customer_id")
    private Optional<Customer> customer;

    public Statistic()
    {
    }

    public Statistic(Optional<Customer> customer)
    {
        this.customer = customer;
    }
}
