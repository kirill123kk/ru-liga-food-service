package ru.liga.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.dto.RabbitStatusDto;
import ru.liga.rabbit.config.RoutingMQConfig;

@Slf4j
@RestController

@RequiredArgsConstructor
@RequestMapping("/inside")
public class KitchenRabbitController {

    @SneakyThrows
    @RabbitListener(queues = RoutingMQConfig.KITCHENTONOTIFICATIONQUEUE)
    public void processMyQueue(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        RabbitStatusDto rabbitStatusDto = objectMapper.readValue(message, RabbitStatusDto.class);

        log.info("Received from "+RoutingMQConfig.KITCHENTONOTIFICATIONQUEUE+" : " +  message);
    }


}
