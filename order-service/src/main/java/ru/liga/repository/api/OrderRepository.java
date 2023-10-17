package ru.liga.repository.api;

import ru.liga.dto.OrderAllDto;
import ru.liga.dto.OrderDto;
import ru.liga.dto.ReceiptDto;
import ru.liga.dto.UrlDto;

public interface OrderRepository {
    OrderAllDto findAll();
    OrderDto findById(Long id);

    UrlDto save(ReceiptDto receipt);

    OrderDto update(OrderDto orderDto);
}
