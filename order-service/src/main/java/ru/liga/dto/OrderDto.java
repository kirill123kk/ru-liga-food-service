package ru.liga.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Schema(description = "Дто заказа")
@Data
@Accessors(chain = true)
public class OrderDto {

    @Schema(description = "Ид заказа")
    private Long Id;

    @Schema(description = "Ресторан")
    private Restaurant RestaurantName;

    @Schema(description = "Время заказа")
    private Date Timesamp;

    @Schema(description = "Товар")
    private List<Item> Items;//mass  "price": "","quantity": "","description": "","image": ""


}