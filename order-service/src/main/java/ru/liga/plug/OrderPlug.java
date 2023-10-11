package ru.liga.plug;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import ru.liga.dto.OrderDto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OrderPlug {
   public List<OrderDto> orderDtoList  ;
   public Integer pageIndex=0;
   public Integer pageCount=10;
    public OrderPlug(){
        orderDtoList =new ArrayList<>();
    }
    public OrderDto setOrderDtoList(OrderDto orderDto){

        orderDtoList.add(orderDto);
        return orderDto;
    }
    public void updateOrderDtoList(OrderDto orderDto){

        orderDtoList.set(orderDtoList.indexOf(getOrderDtoListById(orderDto.getId())),orderDto) ;

    }
   public OrderDto getOrderDtoListById(Integer id){

       return orderDtoList.stream().filter(tmp->id.equals(tmp.getId())).findFirst().orElse(null);
   }

}
