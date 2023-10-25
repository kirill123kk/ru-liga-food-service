package ru.liga.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "restaurant_menu_items")
public class RestaurantMenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "restaurant_id")
    private long restaurantId;

    private  String name;

    private double price;

    private String image;

    private  String description;
}
