package ru.liga.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.dto.*;
import ru.liga.mapper.OrderMapper;
import ru.liga.model.*;
import ru.liga.rabbit.config.RoutingMQConfig;
import ru.liga.repository.api.*;
import ru.liga.service.api.OrderService;
import ru.liga.service.api.RabbitService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends OrderMapper implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CustomerRepository customerRepository;
    private final RestaurantsRepository restaurantsRepository;
    private final MenuItemRepository menuItemRepository;
    private final RabbitService rabbitService;
    private final PayRepository payRepository;



    @Override
    public OrderDto getOrderById(UUID id) {
        payRepository.findPayById(1L);
        payRepository.findById(1L);
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
        order.setStatus(String.valueOf(Status.Processed));


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
        Pay pay =new Pay();
        pay.setPayUrl("http//"+order.getId());
        pay.setOrderId(order);


        payRepository.save(pay);
        UrlDto urlDto =new UrlDto();
        urlDto.setId(order.getId());
        urlDto.setSecretPaymentUrl(pay.getPayUrl());
        urlDto.setEstimatedTimeOfArrival(order.getTimestamp());
        return urlDto;
    }

    @Override
    public void payForOrder(UUID orderId,String paymentUrl) {
        OrderMapper orderMapper=new OrderMapper();
        Order order =orderRepository.findById(orderId).orElseThrow();
        if (order.getPay().getPayUrl().equals(paymentUrl) )
        if(order.getStatus().equals(Status.Processed.toString()))
        {
            RabbitStatusDto rabbitStatusDto =new RabbitStatusDto();
            rabbitStatusDto.setId(order.getId());
            rabbitStatusDto.setStatus(Status.Paid);

            rabbitStatusDto.setCourierId(null);
            updateOrderById(order.getId(),rabbitStatusDto);
            OrderMessDto orderMessDto = (OrderMessDto) order;
            rabbitService.sendMessage(orderMessDto, RoutingMQConfig.ORDER_TO_NOTIFICATION);
        }
    }

    @Override
    public OrderDto updateOrderById(UUID id, RabbitStatusDto rabbitStatusDto) {
        orderRepository.updateStatus(id,rabbitStatusDto.getStatus().toString(),rabbitStatusDto.getCourierId());
        return new OrderDto();
    }

    @Override
    public List<OrderDto> getOrders() {
        List<Order> orderList = orderRepository.findAll();
        OrderMapper orderMapper=new OrderMapper();
        List<OrderDto> orderDtoList = orderMapper.toDtoList(orderList);
        return orderDtoList;
    }

}
