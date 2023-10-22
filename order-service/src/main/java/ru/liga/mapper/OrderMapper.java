package ru.liga.mapper;


import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import ru.liga.dto.ItemDto;
import ru.liga.dto.OrderDto;
import ru.liga.dto.ReceiptDto;
import ru.liga.model.Order;
import ru.liga.model.OrderItem;
import ru.liga.model.Restaurant;
import ru.liga.repository.api.OrderItemRepository;
import ru.liga.repository.api.OrderRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Mapper(componentModel = "spring")

public class OrderMapper {
    /*public OrderDto EntityToDto(Order order, OrderItemRepository orderItemRepository) {
        OrderDto orderDto = new OrderDto();
        List<ItemDto> itemDtoList = new ArrayList<>();
        List<OrderItem> itemList = new ArrayList<>();
        itemList = orderItemRepository.findAllById(Collections.singleton(order.getId()));
        for (OrderItem i : itemList) {
            ItemDto itemDto = new ItemDto();
            itemDto.setPrice(i.getPrice());
            itemDto.setQuantity(i.getQuantity());
        }
        orderDto.setId(order.getId());
        orderDto.setItems(itemDtoList);
        courerDto.setStatus(courer.getStatus());
        courerDto.setCoordinats(courer.getCoordinats());
        return courerDto;
    }*/

    public Order OrderDtoToOrderEntity(OrderDto orderDto,OrderItemRepository orderItemRepository){
        orderDto.getItems();
        /*for (ItemDto i : orderDto.getItems()){
            OrderItem orderItem =new OrderItem();
            orderItem.setOrderId(orderDto.getId());
            orderItem.setPrice(i.getPrice());
            orderItem.setQuantity(i.getQuantity());
            orderItem.setRestaurantMenuItems(orderDto.getRestaurantDtoName().getId());//заглушка
            orderItemRepository.save(orderItem);
        }
*/
        Restaurant restaurant=new Restaurant();
        restaurant.setId(orderDto.getRestaurantDtoName().getId());

        Order order = new Order();
        order.setId(orderDto.getId());
        order.setTimestamp(orderDto.getTimestamp());
        order.setRestaurantId(restaurant);
        order.setStatus("Обрабатывается");

        return order;
    }
    public Order ReceiptDtoToOrderEntity(ReceiptDto receiptDto, OrderItemRepository orderItemRepository){
        Order order = new Order();
        order.getRestaurantId().setId(receiptDto.getRestrauntId());


        /*order.setId(orderDto.getId());
        order.setTimestamp(orderDto.getTimestamp());
        order.setRestaurantId(restaurant);*/
        order.setStatus("Обрабатывается");

        return order;
    }
}
