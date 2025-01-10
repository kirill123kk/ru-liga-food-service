package ru.liga.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.liga.dto.OrderDto;
import ru.liga.dto.OrderMessDto;
import ru.liga.dto.RabbitStatusDto;
import ru.liga.mapper.OrderMapper;
import ru.liga.repository.api.OrderRepository;
import ru.liga.service.api.RabbitService;
@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitServiceImpl implements RabbitService {
    private final OrderRepository orderRepository;
    private final RabbitTemplate rabbitTemplate;
    public void updateStatusById(RabbitStatusDto rabbitStatusDto) {
        orderRepository.updateStatus(rabbitStatusDto.getId(),rabbitStatusDto.getStatus().toString(),rabbitStatusDto.getCourierId());

    }

    @Override
    public void sendMessage(OrderMessDto orderDto, String routingKey) {
        rabbitTemplate.convertAndSend("directExchange",routingKey,orderDto);
        log.info(String.valueOf(rabbitTemplate));
    }


}
