package ru.liga.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.liga.model.Courer;
import ru.liga.model.Status;

import java.util.UUID;

@Schema(description = "Дто передачи статуса для заказа")
@Data
public class RabbitStatusDto {
    @Schema(description = "Id заказа")
    UUID id;

    @Schema(description = "Статус заказа")
    Status status;

    @Schema(description = "Курьер привязанный к заказу")
    Courer courierId;
}
