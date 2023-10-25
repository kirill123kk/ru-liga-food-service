package ru.liga.rabbit.api;

import ru.liga.model.MessageModel;

public interface RabbitService {
    void sendMessage(MessageModel message, String routingKey);
}
