package ru.liga.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.liga.dto.DeliveryAllDto;
import ru.liga.dto.Status;
import ru.liga.repository.api.DeliveryRepository;
import ru.liga.service.api.DeliveryService;


@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Override
    public DeliveryAllDto getAllDelivers() {
        return deliveryRepository.findAll();
    }

    @Override
    public Status create(String action) {

        return deliveryRepository.save(action);
    }


}
