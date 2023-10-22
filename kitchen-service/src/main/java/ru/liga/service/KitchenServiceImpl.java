package ru.liga.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ru.liga.dto.OrderDto;
import ru.liga.dto.RestaurantDto;
import ru.liga.feign.CoreFeign;
import ru.liga.mapper.RestaurantMapper;
import ru.liga.model.MessageModel;
import ru.liga.model.Order;
import ru.liga.rabbit.api.RabbitService;
import ru.liga.repository.OrderRepository;
import ru.liga.repository.RestaurantsRepository;
import ru.liga.service.api.KitchenService;
@Slf4j
@Service
@RequiredArgsConstructor
public class KitchenServiceImpl implements KitchenService {
    private final RestaurantsRepository restaurantsRepository;
    private final OrderRepository orderRepository;
    private final RabbitService rabbitService;
    private final CoreFeign feign;



    @Override
    public void sendInfo(MessageModel messageModel) {
        orderRepository.updateStatus( messageModel.getOrderId(),"приготовлен");

        rabbitService.sendMessage(messageModel, "queue1");
    }

    @Override
    public RestaurantDto getRestaurantById(long id) {
        return new RestaurantMapper().RestaurantToRestaurantDto(restaurantsRepository.findById(id).orElseThrow());
    }

    @Override
    public String setRestaurant(RestaurantDto restaurantDto) {
        restaurantsRepository.save(new RestaurantMapper().RestaurantDtoToRestaurant(restaurantDto));
        return "Ресторан успешно создан";
    }

    @Override
    public String testFeign() {
       feign.getData(1L);
        return "Все успешно";
    }
}
