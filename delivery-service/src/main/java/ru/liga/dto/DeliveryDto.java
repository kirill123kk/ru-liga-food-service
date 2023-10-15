package ru.liga.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Schema(description = "Дто заказа")
@Data
@Accessors(chain = true)
public class DeliveryDto {

    @Schema(description = " Ид заказа")
    private Long orderId;

    @Schema(description = "Ресторан")
    private Restaurant restaurant;

    @Schema(description = "//")
    private Customer customer;

    @Schema(description = "Расчет")
    private Double payment;


}