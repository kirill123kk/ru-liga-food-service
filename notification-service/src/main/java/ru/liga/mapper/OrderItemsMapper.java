package ru.liga.mapper;

import org.mapstruct.Mapper;
import ru.liga.dto.ItemDto;
import ru.liga.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public class OrderItemsMapper {
    public  List<ItemDto> toDtoList ( List<OrderItem> orderItemList){
        List<ItemDto> itemDtoList = new ArrayList<>();
        for (OrderItem oi: orderItemList) {
            ItemDto itemDto = toDto(oi);
            itemDtoList.add(itemDto);
        }
        return itemDtoList;
    }
    public  ItemDto toDto (OrderItem orderItem){
        ItemDto itemDto = new ItemDto();
        itemDto.setPrice(orderItem.getPrice());
        itemDto.setQuantity(orderItem.getQuantity());
        itemDto.setImage(orderItem.getRestaurantMenuItems().getImage());
        itemDto.setDescription(orderItem.getRestaurantMenuItems().getDescription());
        return itemDto;
    }

}
