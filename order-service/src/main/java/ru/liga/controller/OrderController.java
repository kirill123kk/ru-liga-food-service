package ru.liga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.liga.dto.OrderAllDto;
import ru.liga.dto.ReceiptDto;
import ru.liga.dto.UrlDto;
import ru.liga.service.api.OrderService;
import ru.liga.dto.OrderDto;

@Tag(name = "Api для работы с заказами")
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @Operation(summary = "Получить заказы")
    @GetMapping("/orders")
    public OrderAllDto getOrders() {
        return orderService.getAllOrders();
    }

    @Operation(summary = "Получить заказ по ID")
    @GetMapping("/order/{id}")
    public OrderDto getOrderById(@PathVariable("id") Long id) {
        return orderService.getOrderById(id);
    }

    @Operation(summary = "Получить отмененные заказы")
    @GetMapping("/orders?status=active/complete/denied")
    public OrderAllDto getOrdersDenied( ) {
        return orderService.getAllOrders();
    }

    @Operation(summary = "Обновить все данные заказа по ID")
    @PutMapping("/update/{id}")
    public String updateOrderById(@PathVariable("id") Long id, @RequestBody OrderDto orderDto) {
        orderService.changeOrderInfo(id, orderDto);
        return "Заказ изменен";
    }

    @Operation(summary = "Создать новый заказ")
    @PostMapping("/create")
    public UrlDto create(@RequestBody ReceiptDto receipt) {
        return orderService.addNewOrder(receipt);
    }

}