package ru.liga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.dto.nov.CourerDto;
import ru.liga.service.api.CourerService;
import ru.liga.service.api.OrderService;

import java.util.List;
@Slf4j
@Tag(name = "Api для работы с заказами")
@RestController
@RequestMapping("/courer")
@RequiredArgsConstructor
public class CourerController {
        private final CourerService orderService;

        @Operation(summary = "Получить курьера по ID")
        @GetMapping("/courer/{id}")
        public ResponseEntity<CourerDto> getOrderById(@PathVariable("id") Long id) {
            return ResponseEntity.ok( orderService.getOrderById(id));
        }
        @Operation(summary = "Получить курьеров по Status")
        @GetMapping("/courer1/{status}")
        public ResponseEntity<List<CourerDto>>  getOrderByStatus(@PathVariable("status") String status) {
            return ResponseEntity.ok( orderService.getOrderByStatus(status));
        }
}
