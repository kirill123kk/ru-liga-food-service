package ru.liga.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;
@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurantId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id")
    private Courer courer;

    private String status;


    private Date timestamp;

}
