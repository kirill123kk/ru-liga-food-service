package ru.liga.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order orderId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_menu_item")
    private RestaurantMenuItem restaurantMenuItems;

    private double price;

    private long quantity;

}
