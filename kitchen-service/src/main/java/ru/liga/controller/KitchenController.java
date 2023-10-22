package ru.liga.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.liga.dto.RestaurantDto;
import ru.liga.model.MessageModel;
import ru.liga.service.api.KitchenService;



@Slf4j
@RequestMapping("/kitchen")
@RestController
@RequiredArgsConstructor
public class KitchenController {
    private final KitchenService kitchenService;

    Logger logger = LoggerFactory.getLogger(KitchenController.class);
    @PostMapping("/rabbit")
    public ResponseEntity<String> enit(@RequestBody MessageModel messageModel){
        logger.info("Emit to myQueue");

        kitchenService.sendInfo(messageModel);
        return ResponseEntity.ok("you");
    }
    @GetMapping("/feign")
    public  String test () {
        return kitchenService.testFeign();
    }

    @GetMapping("/kitchen/{id}")
    public ResponseEntity<RestaurantDto> getOrderById(@PathVariable("id") Long id) {
        return ResponseEntity.ok( kitchenService.getRestaurantById(id));
    }


    @PostMapping("/kitchens")
    public ResponseEntity<String>  createOrder( @RequestBody RestaurantDto restaurantDto) {
        return ResponseEntity.ok( kitchenService.setRestaurant(restaurantDto));
    }

}
