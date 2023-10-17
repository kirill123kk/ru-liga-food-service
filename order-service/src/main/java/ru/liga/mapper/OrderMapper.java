package ru.liga.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.liga.dto.OrderDto;
import ru.liga.model.Order;

@Mapper
public interface OrderMapper {
    @Mapping(source = "order.id", target = "id")
    @Mapping(source = "order.timestamp", target = "timestamp")
    @Mapping(source = "order.restaurant", target = "restaurant")
    @Mapping(source = "order.items", target = "items")
    OrderDto orderToOrderDto (Order order);


}
