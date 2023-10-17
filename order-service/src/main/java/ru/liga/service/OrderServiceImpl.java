package ru.liga.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.dto.OrderAllDto;
import ru.liga.dto.OrderDto;
import ru.liga.dto.ReceiptDto;
import ru.liga.dto.UrlDto;
import ru.liga.exception.OrderServiceException;
import ru.liga.repository.api.OrderRepository;
import ru.liga.service.api.OrderService;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderAllDto getAllOrders() {
        orderRepository.findAll();
        return orderRepository.findAll();
    }

    @Override
    public OrderDto getOrderById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public UrlDto addNewOrder(ReceiptDto receipt) {
        return orderRepository.save(receipt);
    }

    @Override
    public OrderDto changeOrderInfo(long id, OrderDto order) {
        OrderDto orderToChange = orderRepository.findById(order.getId());
        if(orderToChange == null) throw new OrderServiceException("Нет этого Id " + order.getId());



        return orderRepository.update(orderToChange);
    }
}
