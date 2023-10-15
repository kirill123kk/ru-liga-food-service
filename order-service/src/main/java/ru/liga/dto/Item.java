package ru.liga.dto;

import lombok.Data;

@Data
public class Item {
    private Double price;
    private Integer quantity;
    private String description;
    private String image;
}
