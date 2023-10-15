package ru.liga.repository.api;

import ru.liga.dto.DeliveryAllDto;
import ru.liga.dto.Status;

public interface DeliveryRepository {
    DeliveryAllDto findAll();

    Status save (String action);
}
