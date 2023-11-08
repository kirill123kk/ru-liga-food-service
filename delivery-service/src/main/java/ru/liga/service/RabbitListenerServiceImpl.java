package ru.liga.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.repository.CourerRepository;
import ru.liga.repository.OrderItemRepository;
import ru.liga.repository.OrderRepository;
import ru.liga.service.api.RabbitListenerService;

@Service
@RequiredArgsConstructor
public class RabbitListenerServiceImpl implements RabbitListenerService {
    private final CourerRepository courerRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    @Override
    public void updateStatusById(long orderId,long courerId) {

        courerRepository.updateStatus(courerId,"занят");
        orderRepository.updateCourier(orderId,courerId);
        orderRepository.updateStatus(orderId,"доставляется");

    }
}
