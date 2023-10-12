package ru.liga.OrderService;

import ru.liga.dto.OrderDto;
import ru.liga.errors.OrderErrors;
import ru.liga.plug.OrderPlug;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final OrderPlug repository = new OrderPlug();
    public List<OrderDto> getAllOrders() {
        return new ArrayList<>(repository.orderDtoList.values());
    }
    public OrderDto getOrderById(long id) {
        OrderDto orderToGet = repository.orderDtoList.get(id);
        if(orderToGet == null) throw new OrderErrors("Нет этого ID " + id);
        else return orderToGet;
    }

    public OrderDto addNewOrder(OrderDto order) {
        repository.addOrderDtoList(order);
        return order;
    }
    public OrderDto changeOrderInfo(long id, OrderDto order) {
        OrderDto orderToChange = repository.orderDtoList.get(id);
        if(orderToChange == null) throw new OrderErrors("Нет этого Id " + order.getId());
        else {
            orderToChange.setCourierId(order.getCourierId());
            orderToChange.setCustomerId(order.getCustomerId());

            repository.orderDtoList.put(orderToChange.getId(),orderToChange);
        }
        return orderToChange;
    }
}
