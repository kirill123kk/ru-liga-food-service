package ru.liga.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import ru.liga.dto.DeliveryAllDto;
import ru.liga.dto.Status;
import ru.liga.model.MessageModel;
import ru.liga.rabbit.RoutingMQConfig;
import ru.liga.service.api.DeliveryService;

@Tag(name = "Api для работы с доставкой")
@RestController
@RequestMapping("/delivery")
@RequiredArgsConstructor
@Slf4j
public class DeliveryController {

    private final DeliveryService deliveryService;


    @SneakyThrows
    @RabbitListener(queues = RoutingMQConfig.QUEUE_1)
    public void processMyQueue(MessageModel messageModel) {
        deliveryService.updateStatusById(messageModel.getOrderId(), messageModel.getCourerId());
        log.info("Received from myQueue1 : " +  messageModel);
    }
    @GetMapping("/feign")
    public  String dropId (@RequestParam Long id) {
        return deliveryService.dropFeign(id);
    }

    @Operation(summary = "Получить заказы по ID курьера")
    @GetMapping("/deliveries/{id}")
    public DeliveryAllDto getALLDeliveries(@PathVariable("id") Long id) {
        return deliveryService.getAllDelivers(id);
    }

    @Operation(summary = "Добавление курьера")
    @PostMapping("/delivery")
    public Status create(@RequestParam ("phone") String phone) {
        return deliveryService.create(phone);
    }

}