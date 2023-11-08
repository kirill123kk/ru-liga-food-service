package ru.liga.service.api;


import ru.liga.dto.OrderDto;
import ru.liga.dto.OrderMessDto;
import ru.liga.dto.RabbitStatusDto;

public interface RabbitService {
    void updateStatusById(RabbitStatusDto rabbitStatusDto);
    void sendMessage(OrderMessDto orderDto, String routingKey);
}
