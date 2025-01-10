package ru.liga.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class ReceiptDto {
    @Schema(description = "Id ресторана")
    private Long restrauntId;

    @Schema(description = "Пункты меню")
    private List<MenuItemDto> menuItemDto;
}
