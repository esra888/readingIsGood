package com.example.readingisgood.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Customer")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "customer_id")
    private List<Orders> orders;

    public void Customer()
    {
    }

    public Customer(String name, String mail, String password, List<Orders> orders)
    {
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.orders = orders;
    }
}
