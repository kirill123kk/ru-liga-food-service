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

    private long orderId;

    @Column(name = "restaurant_menu_item")
    private long restaurantMenuItems;

    private double price;

    private long quantity;

}
