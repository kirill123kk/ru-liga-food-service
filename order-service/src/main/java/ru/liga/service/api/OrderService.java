package ru.liga.service.api;

import ru.liga.dto.OrderAllDto;
import ru.liga.dto.OrderDto;
import ru.liga.dto.ReceiptDto;
import ru.liga.dto.UrlDto;

public interface OrderService {
    OrderAllDto getAllOrders();
    OrderDto getOrderById(long id);

    UrlDto addNewOrder(ReceiptDto receipt);
    OrderDto changeOrderInfo(long id, OrderDto order);
}
