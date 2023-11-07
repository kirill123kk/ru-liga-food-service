package ru.liga.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.dto.MenuItemDto;
import ru.liga.dto.OrderDto;
import ru.liga.dto.ReceiptDto;
import ru.liga.dto.UrlDto;
import ru.liga.mapper.OrderItemsMapper;
import ru.liga.mapper.OrderMapper;
import ru.liga.model.Order;
import ru.liga.model.OrderItem;
import ru.liga.model.RestaurantMenuItem;
import ru.liga.repository.api.*;
import ru.liga.service.api.OrderService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends OrderMapper implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CustomerRepository customerRepository;
    private final RestaurantsRepository restaurantsRepository;
    private final MenuItemRepository menuItemRepository;



    @Override
    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow();
        OrderMapper orderMapper=new OrderMapper();
        OrderDto orderDto = orderMapper.toDto(order);
        return orderDto;
    }

    @Override
    public UrlDto setOrder(long customer, ReceiptDto receiptDto) {
        Order order=new Order();

        order.setCustomerId(customerRepository.findById(customer).orElseThrow());
        order.setRestaurantId(restaurantsRepository.findById(receiptDto.getRestrauntId()).orElseThrow());
        order.setTimestamp(new Date());
        order.setStatus("Обрабатываеться");
        orderRepository.save(order);


        for(MenuItemDto i: receiptDto.getMenuItemDto()){
            OrderItem orderItem=new OrderItem();
            RestaurantMenuItem restaurantMenuItem =menuItemRepository.findById(i.getMenuItemId()).orElseThrow();
            orderItem.setOrderId(order);
            orderItem.setRestaurantMenuItems(restaurantMenuItem);
            orderItem.setQuantity(i.getQuantity());
            orderItem.setPrice(restaurantMenuItem.getPrice());
            orderItemRepository.save(orderItem);
        }
        UrlDto urlDto =new UrlDto();
        urlDto.setId(order.getId());
        urlDto.setSecretPaymentUrl("http//>>???...");
        urlDto.setEstimatedTimeOfArrival(new Date());
        return urlDto;
    }

    @Override
    public List<OrderDto> getOrders() {
        List<Order> orderList = orderRepository.findAll();
        OrderMapper orderMapper=new OrderMapper();
        List<OrderDto> orderDtoList = orderMapper.toDtoList(orderList);
        return orderDtoList;
    }

    @Override
    public List<OrderDto> getOrderByStatus(String status) {
        List<Order> orderList = orderRepository.findOrderByStatus(status);
        OrderMapper orderMapper=new OrderMapper();
        List<OrderDto> orderDtoList = orderMapper.toDtoList(orderList);
        return orderDtoList;
    }


}
