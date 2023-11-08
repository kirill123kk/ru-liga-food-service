package ru.liga.rabbit.api;

import ru.liga.dto.RabbitStatusDto;
import ru.liga.model.MessageModel;

public interface RabbitService {
    void sendMessage(RabbitStatusDto rabbitStatusDto, String routingKey);
}
