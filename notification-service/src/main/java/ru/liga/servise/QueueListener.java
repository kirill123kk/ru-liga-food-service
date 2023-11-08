package ru.liga.servise;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.liga.config.RoutingMQConfig;
import ru.liga.dto.OrderDto;
import ru.liga.dto.OrderMessDto;

@EnableRabbit
@Service
@RequiredArgsConstructor
@Slf4j
public class QueueListener {
    private final RabbitTemplate rabbitTemplate;
    @RabbitListener(queues = RoutingMQConfig.ORDER_TO_NOTIFICATION)
    public void handleNewOrder(OrderMessDto orderDto) {
        rabbitTemplate.convertAndSend(RoutingMQConfig.ORDER_TO_KITCHEN,orderDto);
        log.info("Order id={} send to kitchen", orderDto.getId());
    }
}
