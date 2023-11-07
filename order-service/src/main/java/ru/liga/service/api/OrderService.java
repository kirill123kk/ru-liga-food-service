package ru.liga.service.api;

import ru.liga.dto.OrderDto;
import ru.liga.dto.ReceiptDto;
import ru.liga.dto.UrlDto;

import java.util.List;

public interface OrderService {
    OrderDto getOrderById(Long id);
    UrlDto setOrder(long customer, ReceiptDto orderDto);
    List<OrderDto> getOrderByStatus(String status);
    List<OrderDto> getOrders();

}
