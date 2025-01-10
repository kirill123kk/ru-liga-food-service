package ru.liga.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private long id;

    private String phone;

    private String email;

    private String address;
}
