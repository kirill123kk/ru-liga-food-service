package ru.liga.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ItemDto {
    @Schema(description = "Цена")
    private Double price;

    @Schema(description = "Количество")
    private Long quantity;

    @Schema(description = "Описание")
    private String description;

    @Schema(description = "Картинка")
    private String image;
}
