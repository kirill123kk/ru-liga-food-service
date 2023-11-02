package ru.liga.model;

import lombok.Data;


import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @OneToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurantId;


    private String status;


    private Date timestamp;

}
