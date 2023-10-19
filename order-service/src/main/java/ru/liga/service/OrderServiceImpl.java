package ru.liga.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.dto.OrderDto;
import ru.liga.model.Order;
import ru.liga.repository.api.OrderRepository;
import ru.liga.service.api.OrderService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;



    @Override
    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow();
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setTimestamp(order.getTimestamp());

        return orderDto;
    }

    @Override
    public List<OrderDto> getOrderByStatus(String status) {
        List<Order> orderList = orderRepository.findOrderByStatus(status);
        List<OrderDto> orderDtoList = new ArrayList<>();

        for (Order tmp : orderList) {
            OrderDto orderDto =new OrderDto();
            orderDto.setId(tmp.getId());
            orderDto.setTimestamp(tmp.getTimestamp());
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }


}
