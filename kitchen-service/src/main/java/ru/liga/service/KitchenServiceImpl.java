package ru.liga.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.dto.OrderDto;
import ru.liga.dto.OrderMessDto;
import ru.liga.dto.RabbitStatusDto;
import ru.liga.dto.RestaurantDto;
import ru.liga.mapper.RestaurantMapper;
import ru.liga.model.MessageModel;
import ru.liga.model.Order;
import ru.liga.model.Status;
import ru.liga.rabbit.api.RabbitService;
import ru.liga.rabbit.config.RoutingMQConfig;
import ru.liga.repository.OrderRepository;
import ru.liga.repository.RestaurantsRepository;
import ru.liga.service.api.KitchenService;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class KitchenServiceImpl implements KitchenService {
    private final RestaurantsRepository restaurantsRepository;
    private final RabbitService rabbitService;
    private final List<OrderMessDto> orderList;

    public void setOrderList (OrderMessDto orderList){
        this.orderList.add(orderList);
    }
    public void deleteOrderInList(){
        this.orderList.remove(0);
    }
    public OrderMessDto getOrder (){
        return this.orderList.get(0);
    }

    @Override
    public void sendInfo(Boolean ind) {
        OrderMessDto orderDto = getOrder();
        RabbitStatusDto rabbitStatusDto =new RabbitStatusDto();
        if(ind){
            rabbitStatusDto.setId(orderDto.getId());
            rabbitStatusDto.setCourierId(orderDto.getCourer());
            rabbitStatusDto.setStatus(Status.ACTIVE);

            rabbitService.sendMessage(rabbitStatusDto, RoutingMQConfig.KITCHENTONOTIFICATIONQUEUE);
        }
        else {
            rabbitStatusDto.setId(orderDto.getId());
            rabbitStatusDto.setCourierId(orderDto.getCourer());
            rabbitStatusDto.setStatus(Status.DENIED);
            deleteOrderInList();
            rabbitService.sendMessage(rabbitStatusDto, RoutingMQConfig.KITCHENTONOTIFICATIONQUEUE);
        }
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
    public void completeOrder() {
        OrderMessDto orderDto = getOrder();
        RabbitStatusDto rabbitStatusDto =new RabbitStatusDto();
        rabbitStatusDto.setId(orderDto.getId());
        rabbitStatusDto.setCourierId(orderDto.getCourer());
        rabbitStatusDto.setStatus(Status.COMPLETE);
        deleteOrderInList();
        rabbitService.sendMessage(rabbitStatusDto, RoutingMQConfig.KITCHENTONOTIFICATIONQUEUE);

    }


}
