package ru.liga.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Schema(description = "Дто заказа")
@Data
@Accessors(chain = true)
public class OrderDto {
    @Schema(description = "Ид заказа")
    private UUID id;

    @Schema(description = "Ресторан")
    private RestaurantDto restaurantDtoName;

    @Schema(description = "Время заказа")
    private Date timestamp;

    @Schema(description = "Товар")
    private List<ItemDto> Items;
}