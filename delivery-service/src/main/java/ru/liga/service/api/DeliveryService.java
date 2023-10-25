package ru.liga.service.api;

import ru.liga.dto.DeliveryAllDto;
import ru.liga.dto.Status;


public interface DeliveryService {
    DeliveryAllDto getAllDelivers(long id);
    Status create(String phone);
    void updateStatusById(long orderId,long courerId);
    String dropFeign(Long id);
 }
