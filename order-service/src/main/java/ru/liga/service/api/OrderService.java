package ru.liga.service.api;

import ru.liga.dto.OrderDto;
import ru.liga.dto.RabbitStatusDto;
import ru.liga.dto.ReceiptDto;
import ru.liga.dto.UrlDto;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    OrderDto getOrderById(UUID id);
    UrlDto setOrder(long customer, ReceiptDto orderDto);
    void payForOrder(UUID orderId,String paymentUrl);
    List<OrderDto> getOrders();
    OrderDto updateOrderById(UUID id, RabbitStatusDto rabbitStatusDto);
}
