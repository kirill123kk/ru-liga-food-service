package ru.liga.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDto {
    private long id;

    private CustomerDto customerId;

    private RestaurantDto restaurantId;

    private CourerDto courer;

    private String status;

    private Date timestamp;
}
