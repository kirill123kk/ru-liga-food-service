package ru.liga.service.api;

import ru.liga.dto.nov.CourerDto;

import java.util.List;

public interface CourerService {
    CourerDto getOrderById(Long id);

    List<CourerDto> getOrderByStatus(String status);
}
