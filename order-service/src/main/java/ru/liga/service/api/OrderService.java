package ru.liga.service.api;

import ru.liga.dto.OrderAllDto;
import ru.liga.dto.OrderDto;
import ru.liga.dto.Receipt;
import ru.liga.dto.Url;

public interface OrderService {
    OrderAllDto getAllOrders();
    OrderDto getOrderById(long id);

    Url addNewOrder(Receipt receipt);
    OrderDto changeOrderInfo(long id, OrderDto order);
}
