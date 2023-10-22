package ru.liga.rabbit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.stereotype.Service;
import ru.liga.model.MessageModel;
import ru.liga.rabbit.api.RabbitService;
@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitServiceImpl implements RabbitService {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public void sendMessage(MessageModel message, String routingKey) {
        try {
            rabbitTemplate.convertAndSend(routingKey,objectMapper.writeValueAsString(message) );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        log.info(String.valueOf(rabbitTemplate));
    }

}
