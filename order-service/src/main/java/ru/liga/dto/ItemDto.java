package ru.liga.dto;

import lombok.Data;

@Data
public class ItemDto {
    private Double price;

    private Long quantity;

    private String description;

    private String image;
}
