package ru.liga.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReceiptDto {
    private Long RestrauntId;
    private List<MenuItemDto> menuItemDtos;
}
