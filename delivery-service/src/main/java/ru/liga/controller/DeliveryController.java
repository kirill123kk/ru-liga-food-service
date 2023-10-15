package ru.liga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import ru.liga.dto.DeliveryAllDto;
import ru.liga.dto.Status;
import ru.liga.service.api.DeliveryService;

@Tag(name = "Api для работы с доставкой")
@RestController
@RequestMapping("/delivery")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;


    @Operation(summary = "Получить заказ по ID")
    @GetMapping("/deliveries")
    public DeliveryAllDto getDeliveries() {
        return deliveryService.getAllDelivers();
    }

    @Operation(summary = "Получить заказ по ID")
    @PostMapping("/delivery/{action}")
    public Status create(@PathVariable("action") String action) {
        return deliveryService.create(action);
    }

}