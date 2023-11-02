package ru.liga.service.api;

import ru.liga.dto.RestaurantDto;
import ru.liga.model.MessageModel;

public interface KitchenService {
    void sendInfo(MessageModel messageModel);
    RestaurantDto getRestaurantById (long id);
    String setRestaurant(RestaurantDto restaurantDto);

}
