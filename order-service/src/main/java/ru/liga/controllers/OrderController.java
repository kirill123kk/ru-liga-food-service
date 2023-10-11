package ru.liga.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.liga.dto.OrderDto;
import ru.liga.plug.OrderPlug;

import java.util.ArrayList;
import java.util.List;


@Tag(name = "Api для работы с заказами")
@RestController
@RequestMapping("/order")
public class OrderController {

    OrderPlug orderData =new OrderPlug();
    @Operation(summary = "Получить заказы")
    @GetMapping("")
    public OrderPlug getOrders() {
        return  orderData;

    }

    @Operation(summary = "Получить заказ по ID")
    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable("id") Integer id) {
        return orderData.getOrderDtoListById(id);
    }

    @Operation(summary = "Обновить все данные заказа по ID")
    @PutMapping("/update")
    public String updateOrerById(@RequestBody OrderDto orderDto) {
        orderData.updateOrderDtoList(orderDto);
        return "Заказ изменен";
    }

    //http://localhost:8080/restaurant/order/1/303


    //http://localhost:8080/restaurant/1?summ=303



    @Operation(summary = "Создать новый заказ")
    @PostMapping("/create")
    public OrderDto create(@RequestParam Integer id,
            @RequestParam Integer restrauntId,
            @RequestParam Integer menuItems) {

        OrderDto orderDto =new OrderDto();
        orderDto.setId(id).setSecretPaymentUrl(restrauntId).setEstimatedTimeOfArrival(menuItems);
        orderData.setOrderDtoList(orderDto);
        return orderDto;
    }


}