package ru.liga.mapper;

import ru.liga.dto.nov.CourerDto;
import ru.liga.model.Courer;

public class CourerMapper {

    public CourerDto EntityToDto (Courer courer){
        CourerDto courerDto =new CourerDto();
        courerDto.setId(courer.getId());
        courerDto.setPhone(courer.getPhone());
        courerDto.setStatus(courer.getStatus());
        courerDto.setCoordinats(courer.getCoordinats());
        return courerDto;
    }
}
