package ru.liga.model;

import lombok.Data;
import ru.liga.status.Status;

import javax.persistence.*;

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

    @Enumerated(EnumType.STRING)
    private Status status;

}
