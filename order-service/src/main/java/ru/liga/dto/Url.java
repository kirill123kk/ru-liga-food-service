package ru.liga.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Url {
    private Long id;
    private String secretPaymentUrl;
    private Date estimatedTimeOfArrival;
}
