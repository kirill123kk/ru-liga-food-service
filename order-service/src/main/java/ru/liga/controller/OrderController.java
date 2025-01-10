package ru.liga.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.liga.dto.RabbitStatusDto;
import ru.liga.dto.ReceiptDto;
import ru.liga.dto.UrlDto;
import ru.liga.service.api.OrderService;
import ru.liga.dto.OrderDto;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController

@RequiredArgsConstructor
@RequestMapping("/outside")
public class OrderController {

    private final OrderService orderService;


    @Operation(summary = "Получить заказ по ID")
    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDto>  getOrderById(@PathVariable("id") UUID id) {
        log.info("REST: OrderController: getOrderById("+ id +")-получение заказа по ID");
        return ResponseEntity.ok( orderService.getOrderById(id));
    }

    @Operation(summary = "Создание заказа")
    @PostMapping("/order/{orderId}")
    public void payForOrder(@PathVariable UUID orderId, @RequestParam String paymentUrl) {
        log.info("Received POST request to pay for order id={}", orderId);
        orderService.payForOrder(orderId, paymentUrl);
    }

    @Operation(summary = "Создание заказа")
    @PostMapping("/orders/{customers}")
    public ResponseEntity<UrlDto>  createOrder(@PathVariable("customers") Long customers, @RequestBody ReceiptDto receiptDto) {
        return ResponseEntity.ok( orderService.setOrder(customers,receiptDto));
    }

    @Operation(summary = "Обновление заказа")
    @PutMapping("/order/pay/{id}")
    public void   payOrder(@PathVariable("id") UUID id,@RequestParam String url) {
        log.info("REST: OrderController: updateOrder("+ id +")-обновление заказа по ID");
        orderService.payForOrder(id,url);
    }


    @Operation(summary = "Обновление заказа")
    @PutMapping("/order/update/{id}")
    public ResponseEntity<OrderDto>  updateOrder(@PathVariable("id") UUID id,@RequestBody String updateMassage) {
        ObjectMapper objectMapper =new ObjectMapper();
        log.info("REST: OrderController: updateOrder("+ id +")-обновление заказа по ID");
        try {
            return ResponseEntity.ok( orderService.updateOrderById(id,objectMapper.readValue(updateMassage, RabbitStatusDto.class)));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Получение списка заказов")
    @GetMapping("/orders/all")
    public ResponseEntity<List<OrderDto>>  getOrders() {
        return ResponseEntity.ok( orderService.getOrders());
    }
}