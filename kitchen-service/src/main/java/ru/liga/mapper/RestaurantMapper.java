package ru.liga.mapper;

import ru.liga.dto.RestaurantDto;
import ru.liga.model.Restaurant;

public class RestaurantMapper {


    public RestaurantDto RestaurantToRestaurantDto (Restaurant restaurant){
        RestaurantDto restaurantDto = new RestaurantDto();
        restaurantDto.setId(restaurant.getId());
        restaurantDto.setAddress(restaurant.getAddress());
        restaurantDto.setStatus(restaurant.getStatus());
        return restaurantDto;
    }
    public Restaurant RestaurantDtoToRestaurant (RestaurantDto restaurantDto){
        Restaurant restaurant  = new Restaurant();
        restaurant.setId(restaurantDto.getId());
        restaurant.setAddress(restaurantDto.getAddress());
        restaurant.setStatus(restaurantDto.getStatus());
        return restaurant;
    }
}
