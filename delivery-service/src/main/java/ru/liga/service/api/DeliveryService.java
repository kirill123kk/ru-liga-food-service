package ru.liga.service.api;

import ru.liga.dto.DeliveryAllDto;
import ru.liga.dto.Status;


public interface DeliveryService {
    DeliveryAllDto getAllDelivers();
    Status create (String action);
 }
