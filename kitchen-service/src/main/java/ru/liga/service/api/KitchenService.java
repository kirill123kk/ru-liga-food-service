package ru.liga.service.api;

import ru.liga.dto.OrderMessDto;
import ru.liga.dto.RabbitStatusDto;
import ru.liga.dto.RestaurantDto;
import ru.liga.model.MessageModel;

import java.util.List;
import java.util.UUID;

public interface KitchenService {
    List<OrderMessDto> orderList = null;
    void sendInfo( Boolean ind);
    RestaurantDto getRestaurantById (long id);
    String setRestaurant(RestaurantDto restaurantDto);
    void completeOrder();


}
