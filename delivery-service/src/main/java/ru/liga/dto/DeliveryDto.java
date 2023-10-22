package ru.liga.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;



@Schema(description = "//")
@Data
@Accessors(chain = true)
public class DeliveryDto {

    @Schema(description = " Ид заказа")
    private Long orderId;

    @Schema(description = "Ресторан")
    private RestaurantDto restaurant;

    @Schema(description = "Покупатель")
    private CustomerDto customer;

    @Schema(description = "Расчет")
    private Double payment;


}