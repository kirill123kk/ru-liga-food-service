package ru.liga.repository;

import org.springframework.stereotype.Repository;
import ru.liga.dto.DeliveryAllDto;
import ru.liga.dto.Status;
import ru.liga.repository.api.DeliveryRepository;

import static ru.liga.dto.Status.OK;


@Repository

public class DeliveryRepositoryImpl implements DeliveryRepository {

    @Override
    public DeliveryAllDto findAll() { return new DeliveryAllDto(); }

    @Override
    public Status save(String action) {
        Status status =OK;
        return status;
    }


}

