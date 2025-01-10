package ru.liga.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RestaurantDto {
    @Schema(description = "Id")
    private  long id;

    @Schema(description = "Название")
    private String name;

}
