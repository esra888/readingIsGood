package com.example.readingisgood.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Order")
public class Orders
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "localDateTime")
    private LocalDateTime localDateTime;

    @Column(name = "numberOfOrder")
    private int numberOfOrder;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "order_books",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    private List<Book> books = new ArrayList<>();

    public Orders()
    {
    }


    public Orders(LocalDateTime localDateTime, int numberOfOrder)
    {
        this.localDateTime = localDateTime;
        this.numberOfOrder = numberOfOrder;
    }

    public Orders(LocalDateTime localDateTime, int numberOfOrder, List<Book> books)
    {
        this.localDateTime = localDateTime;
        this.numberOfOrder = numberOfOrder;
        this.books = books;
    }
}
