package ru.liga.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UrlDto {
    private Long id;
    private String secretPaymentUrl;
    private Date estimatedTimeOfArrival;
}
