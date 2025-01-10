package ru.liga.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.dto.RabbitStatusDto;
import ru.liga.model.Status;
import ru.liga.rabbit.config.RoutingMQConfig;
import ru.liga.service.api.RabbitService;

@Slf4j
@RestController

@RequiredArgsConstructor
@RequestMapping("/inside")
public class OrdeRabbitController {
    private final RabbitService rabbitService;
    @SneakyThrows
    @RabbitListener(queues = RoutingMQConfig.KITCHEN_TO_ORDER)
    public void processMyQueue(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        RabbitStatusDto rabbitStatusDto = objectMapper.readValue(message, RabbitStatusDto.class);
        rabbitService.updateStatusById(rabbitStatusDto);
        log.info("Received from "+RoutingMQConfig.KITCHEN_TO_ORDER+" : " +  message);
    }
}
