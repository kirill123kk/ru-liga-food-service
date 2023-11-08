package ru.liga.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.liga.dto.RabbitStatusDto;
import ru.liga.dto.RestaurantDto;
import ru.liga.model.MessageModel;
import ru.liga.service.api.KitchenService;



@Slf4j
@RequestMapping("/kitchen")
@RestController
@RequiredArgsConstructor
public class KitchenController {
    private final KitchenService kitchenService;

@Schema(name = "принятие решения по заказу")
    @PutMapping("/order/")
    public ResponseEntity<String> enit(@RequestParam Boolean ind){
        kitchenService.sendInfo(ind);
        log.info("Emit to myQueue");

        return ResponseEntity.ok("отправлено");
    }

    @Schema(name = "заказ готов")
    @PutMapping("/order/")
    public ResponseEntity<String> complete(){
        kitchenService.completeOrder();
        log.info("Emit to myQueue");

        return ResponseEntity.ok("приготовлено");
    }

    @GetMapping("/feign/{id}")
    public Long getById(@PathVariable("id") Long id) {
        return id;
    }


    @GetMapping("/kitchen/{id}")
    public ResponseEntity<RestaurantDto> getOrderById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(kitchenService.getRestaurantById(id));
    }


    @PostMapping("/kitchens")
    public ResponseEntity<String>  createOrder( @RequestBody RestaurantDto restaurantDto) {
        return ResponseEntity.ok(kitchenService.setRestaurant(restaurantDto));
    }

}
