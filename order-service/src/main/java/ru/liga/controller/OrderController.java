package ru.liga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.liga.dto.ReceiptDto;
import ru.liga.dto.UrlDto;
import ru.liga.service.api.OrderService;
import ru.liga.dto.OrderDto;

import java.util.List;

@Slf4j
@RestController

@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @Operation(summary = "Получить заказ по ID")
    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDto>  getOrderById(@PathVariable("id") Long id) {
        log.info("REST: OrderController: getOrderById("+ id +")-получение заказа по ID");
        return ResponseEntity.ok( orderService.getOrderById(id));
    }

    @Operation(summary = "Создание заказа")
    @PostMapping("/orders/{customers}")
    public ResponseEntity<UrlDto>  createOrder(@PathVariable("customers") Long customers, @RequestBody ReceiptDto receiptDto) {
        return ResponseEntity.ok( orderService.setOrder(customers,receiptDto));
    }
    @Operation(summary = "Получить заказ по Status")
    @GetMapping("/order1/{status}")
    public ResponseEntity<List<OrderDto>>  getOrderByStatus(@PathVariable("status") String status) {
        return ResponseEntity.ok( orderService.getOrderByStatus(status));
    }
}