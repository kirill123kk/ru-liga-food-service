package ru.liga.rabbit;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.liga.dto.RabbitStatusDto;
import ru.liga.rabbit.api.RabbitService;
@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitServiceImpl implements RabbitService {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public void sendMessage(RabbitStatusDto rabbitStatusDto, String routingKey) {
        rabbitTemplate.convertAndSend("directExchange",routingKey,rabbitStatusDto );
        log.info(String.valueOf(rabbitTemplate));
    }

}
