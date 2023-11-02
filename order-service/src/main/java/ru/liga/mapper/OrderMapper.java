package ru.liga.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ru.liga.dto.OrderDto;
import ru.liga.model.Order;


@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "order.id", target = "id")
    @Mapping(source = "order.timestamp", target = "timestamp")
    OrderDto orderToOrderDto(Order order);



}
