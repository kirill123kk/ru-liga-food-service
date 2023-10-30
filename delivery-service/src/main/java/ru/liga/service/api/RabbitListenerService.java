package ru.liga.service.api;

import org.springframework.stereotype.Service;


public interface RabbitListenerService {
    void updateStatusById(long orderId,long courerId);
}
