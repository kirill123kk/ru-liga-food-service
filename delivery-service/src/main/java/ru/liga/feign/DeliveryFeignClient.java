package ru.liga.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "core-service", url = "http://localhost:8080/restaurant")
public interface DeliveryFeignClient {

    @GetMapping("/kitchen/feign/{Id}")
     void getData(@PathVariable("Id") Long Id) ;

}
