package ru.liga.plug;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import ru.liga.dto.OrderDto;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderPlug {
    public HashMap<Long, OrderDto> orderDtoList  ;
    public Long id;

    public OrderPlug(){
        orderDtoList =new HashMap<>();
        id = 0L;
    }
    public OrderDto addOrderDtoList(OrderDto orderDto){

        orderDtoList.put(Long.valueOf(orderDto.getId()), orderDto);
        return orderDto;
    }
    public void setOrderDtoList(OrderDto orderDto){

        orderDtoList.put(Long.valueOf(orderDto.getId()), orderDto);

    }
    public void updateOrderDtoList(OrderDto orderDto){

        orderDtoList.put(Long.valueOf(orderDto.getId()),orderDto) ;

    }
    public OrderDto getOrderDtoListById(Long id){

       return orderDtoList.get(id);
   }

}
