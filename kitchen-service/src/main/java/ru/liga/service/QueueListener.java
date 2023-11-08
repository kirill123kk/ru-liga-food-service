package ru.liga.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.liga.dto.OrderDto;
import ru.liga.dto.OrderMessDto;
import ru.liga.rabbit.config.RoutingMQConfig;
import ru.liga.service.api.KitchenService;

@EnableRabbit
@Service
@RequiredArgsConstructor
@Slf4j
public class QueueListener {
    private final KitchenServiceImpl kitchenService;
    @RabbitListener(queues = RoutingMQConfig.ORDER_TO_KITCHEN)
    public void handleNewOrder(OrderMessDto orderDto) {
        kitchenService.setOrderList(orderDto);
        log.info("New order id={} has arrived", orderDto.getId());
    }
}