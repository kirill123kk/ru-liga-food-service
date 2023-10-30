package ru.liga.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.dto.RestaurantDto;
import ru.liga.mapper.RestaurantMapper;
import ru.liga.model.MessageModel;
import ru.liga.rabbit.api.RabbitService;
import ru.liga.rabbit.config.RoutingMQConfig;
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




    @Override
    public void sendInfo(MessageModel messageModel) {
        orderRepository.updateStatus( messageModel.getOrderId(),"приготовлен");

        rabbitService.sendMessage(messageModel, RoutingMQConfig.QUEUE_1);
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


}
