package ru.liga.repository.api;

import ru.liga.dto.OrderAllDto;
import ru.liga.dto.OrderDto;
import ru.liga.dto.Receipt;
import ru.liga.dto.Url;

public interface OrderRepository {
    OrderAllDto findAll();
    OrderDto findById(Long id);

    Url save(Receipt receipt);

    OrderDto update(OrderDto orderDto);
}
