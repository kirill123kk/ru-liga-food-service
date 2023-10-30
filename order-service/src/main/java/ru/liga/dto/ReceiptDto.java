package ru.liga.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReceiptDto {
    private Long restrauntId;
    private List<MenuItemDto> menuItemDto;
}
