package ru.liga.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import ru.liga.OrderService.OrderService;
import ru.liga.dto.OrderDto;
import java.util.List;


@Tag(name = "Api для работы с заказами")
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderData =new OrderService();
    @Operation(summary = "Получить заказы")
    @GetMapping("/orders")
    public List<OrderDto> getOrders() {
        return orderData.getAllOrders();
    }

    @Operation(summary = "Получить заказ по ID")
    @GetMapping("/order/{id}")
    public OrderDto getOrderById(@PathVariable("id") Long id) {
        return orderData.getOrderById(id);
    }

    @Operation(summary = "Обновить все данные заказа по ID")
    @PutMapping("/update")
    public String updateOrerById(@PathVariable("id") Long id, @RequestBody OrderDto orderDto) {
        orderData.changeOrderInfo(id,orderDto);
        return "Заказ изменен";
    }

    //http://localhost:8080/restaurant/order/1/303


    //http://localhost:8080/restaurant/1?summ=303



    @Operation(summary = "Создать новый заказ")
    @PostMapping("/create")
    public OrderDto create(@RequestBody OrderDto orderDto) {


        orderData.addNewOrder(orderDto);
        return orderDto;
    }


}