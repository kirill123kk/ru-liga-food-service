package ru.liga.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MenuItemDto {

    @Schema(description = "Количество")
    private Integer quantity;

    @Schema(description = "Пункт меню")
    private Long menuItemId;
}
