package ru.liga.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Schema(description = "Дто заказа")
@Data
@Accessors(chain = true)
public class OrderDto {

    @Schema(description = "Ид заказа")
    private Integer Id;

    @Schema(description = "Ник")
    private Integer CustomerId;

    @Schema(description = "Ид заказа")
    private Integer Restaurant;//добавить масиив

    @Schema(description = "Статус")
    private Integer Status;

    @Schema(description = "Ид курьера")
    private Integer CourierId;

    @Schema(description = "Время заказа")
    private Integer Timesamp;

    @Schema(description = "Товар")
    private Integer Items;//mass  "price": "","quantity": "","description": "","image": ""

    @Schema(description = "Время заказа")
    private Integer SecretPaymentUrl;

    @Schema(description = "Время заказа")
    private Integer EstimatedTimeOfArrival;

}