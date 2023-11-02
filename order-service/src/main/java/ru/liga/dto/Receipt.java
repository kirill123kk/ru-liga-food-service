package ru.liga.dto;

import lombok.Data;

import java.util.List;

@Data
public class Receipt {
    private Long RestrauntId;
    private List<MenuItem> menuItems;
}
