package ru.liga.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Schema(description = "Дто заказов")
@Data
@Accessors(chain = true)

public class OrderAllDto  {

    @Schema(description = "Заказы")
    private List<OrderDto> orderList;

    @Schema(description = "Страница")
    private Integer pageIndex;

    @Schema(description = "Всего страниц")
    private Integer pageCount;
}