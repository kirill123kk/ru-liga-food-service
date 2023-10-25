package ru.liga.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.dto.nov.CourerDto;
import ru.liga.mapper.CourerMapper;
import ru.liga.model.Courer;
import ru.liga.repository.api.CourerRepository;
import ru.liga.service.api.CourerService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourerServiceImpl implements CourerService {

    private final CourerRepository courerRepository;



    @Override
    public CourerDto getOrderById(Long id) {
        Courer courer = courerRepository.findById(id).orElseThrow();
        CourerDto courerDto = new CourerMapper().EntityToDto(courer);
        return courerDto;
    }

    @Override
    public List<CourerDto> getOrderByStatus(String status) {
        List<Courer> courerList = courerRepository.findOrderByStatus(status);
        List<CourerDto> courerDtoList = new ArrayList<>();

        for (Courer tmp : courerList) {
            courerDtoList.add( new CourerMapper().EntityToDto(tmp));
        }
        return courerDtoList;
    }


}
