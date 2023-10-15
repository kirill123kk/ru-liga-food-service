package ru.liga.repository;

import org.springframework.stereotype.Repository;
import ru.liga.dto.*;
import ru.liga.exception.OrderServiceException;
import ru.liga.repository.api.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class OrderRepositoryImpl implements OrderRepository {
    private  OrderAllDto orderAllDto;
    public OrderRepositoryImpl(){
        orderAllDto =new OrderAllDto();
        orderAllDto.setOrderList(new ArrayList<OrderDto>() );
        orderAllDto.setPageIndex(0);
        orderAllDto.setPageCount(0);
    }
    @Override
    public OrderAllDto findAll() { return orderAllDto; }

    @Override
    public OrderDto findById(Long id) { return orderAllDto.getOrderList().stream().filter(tmp->id.equals(tmp.getId())).findFirst().orElse(null);}

    @Override
    public Url save(Receipt receipt) {

        OrderDto orderDto = null;
        List<OrderDto> temp = orderAllDto.getOrderList();
        orderDto.setId(receipt.getRestrauntId());


            temp.add(orderDto);


        orderAllDto.setOrderList(temp);

        return new Url();
    }

    @Override
    public OrderDto update(OrderDto orderDto) {
        List<OrderDto> temp = orderAllDto.getOrderList();
        if(orderAllDto.getOrderList().stream()
                .filter(tmp->orderDto.getId().equals(tmp.getId()))
                .findFirst()
                .orElse(null) != null)  temp.add(orderDto);
        else throw new OrderServiceException(" Нет заказа с таким Id" + orderDto.getId());

        orderAllDto.setOrderList(temp);
        return orderDto;
    }
}
