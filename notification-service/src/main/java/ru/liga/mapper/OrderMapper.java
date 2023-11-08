package ru.liga.mapper;


import org.mapstruct.Mapper;
import ru.liga.dto.OrderDto;
import ru.liga.dto.RestaurantDto;
import ru.liga.model.Order;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring")
public class OrderMapper {


    public List<OrderDto> toDtoList(List<Order> orderList){
        List<OrderDto> orderDtoList = new ArrayList<>();
       for (Order o: orderList){
           orderDtoList.add(toDto(o));
       }
        return orderDtoList;
    }

    public OrderDto toDto(Order order){
        OrderDto orderDto = new OrderDto();
        OrderItemsMapper orderItemsMapper = new OrderItemsMapper();
        orderDto.setId(order.getId());
        RestaurantDto restaurantDto =new RestaurantDto();
        restaurantDto.setId(order.getRestaurantId().getId());
        restaurantDto.setName(order.getRestaurantId().getName());
        orderDto.setRestaurantDtoName(restaurantDto);
        orderDto.setTimestamp(order.getTimestamp());
        orderDto.setItems(orderItemsMapper.toDtoList(order.getOrderItems()));
        return orderDto;
    }

}
