package ru.liga.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class UrlDto {
    private UUID id;
    private String secretPaymentUrl;
    private Date estimatedTimeOfArrival;
}
