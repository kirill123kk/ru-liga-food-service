package ru.liga.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.dto.*;
import ru.liga.feign.DeliveryFeignClient;
import ru.liga.model.Courer;
import ru.liga.model.Order;
import ru.liga.model.OrderItem;
import ru.liga.repository.CourerRepository;
import ru.liga.dto.Status;
import ru.liga.repository.OrderItemRepository;
import ru.liga.repository.OrderRepository;
import ru.liga.service.api.DeliveryService;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final CourerRepository courerRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final DeliveryFeignClient feign;
    @Override
    public DeliveryAllDto getAllDelivers(long id) {
        DeliveryAllDto deliveryAllDto =new DeliveryAllDto();

        List<Order> orderList= orderRepository.findOrdersByCourierId(id);
        List<DeliveryDto> deliveryDtoList = new ArrayList<>();
        for (Order o: orderList){
            DeliveryDto deliveryDto =new DeliveryDto();
            RestaurantDto restaurantDto =new RestaurantDto();
            CustomerDto customerDto = new CustomerDto();
            long a =o.getId();
            List<OrderItem> orderItems = orderItemRepository.findByOrderId(a);

            double summ=0;
            for (OrderItem i: orderItems)
                summ =summ+i.getPrice();
            customerDto.setAddress(o.getCustomerId().getAddress());
            customerDto.setDistance(15L);

            restaurantDto.setAddress(o.getRestaurantId().getAddress());
            restaurantDto.setDistance(2L);

            deliveryDto.setPayment(summ);
            deliveryDto.setCustomer(customerDto);
            deliveryDto.setOrderId(o.getId());
            deliveryDto.setRestaurant(restaurantDto);
            deliveryDtoList.add(deliveryDto);

        }
        deliveryAllDto.setDeliveryList(deliveryDtoList);
        deliveryAllDto.setPageIndex(21);
        deliveryAllDto.setPageCount(100);
        return deliveryAllDto;
    }

    @Override
    public Status create(String phone) {
        Courer courer= new Courer();
        courer.setPhone(phone);
        courer.setCoordinats("0");
        courer.setStatus("активен");
        courerRepository.save(courer);
        Status status = Status.OK;
        return status;
    }
    @Override
    public String dropFeign(Long id) {
        feign.getData(id);

        return "Все успешно";
    }
    @Override
    public void updateStatusById(long orderId,long courerId) {

        courerRepository.updateStatus(courerId,"занят");
        orderRepository.updateCourier(orderId,courerId);
        orderRepository.updateStatus(orderId,"доставляется");

    }


}
