package com.example.readingisgood.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Book")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "Book")
    @JsonIgnore
    private List<Orders> orders = new ArrayList<>();

    public Book()
    {
    }

    public Book(String title, String author, int quantity, BigDecimal price)
    {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.price = price;
    }


    public void addOrdersAndUpdateQuantity(Orders orders)
    {
        this.orders.add(orders);
        orders.getBooks().add(this);
        this.quantity = this.quantity - orders.getNumberOfOrder(); // after each order quantity of books should decrease
    }
}
