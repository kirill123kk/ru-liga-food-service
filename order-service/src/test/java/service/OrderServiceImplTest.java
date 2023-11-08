package service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.liga.OrderServiceApplication;
import ru.liga.controller.OrderController;
import ru.liga.model.Order;
import ru.liga.repository.api.OrderRepository;
import ru.liga.service.api.OrderService;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RequiredArgsConstructor
@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebMvcTest(OrderController.class)
@ContextConfiguration(classes = {OrderServiceApplication.class})
public class OrderServiceImplTest {

    @Mock
    private final OrderRepository orderRepository;
    @MockBean
    private OrderService orderService;
    @Test
    void testGetOrderById() {
        when(orderRepository.findById(UUID.fromString("ds"))).thenReturn(Optional.of(new Order()));
        assertThatThrownBy(() -> orderService.getOrderById(UUID.fromString("ds")))
                .isInstanceOf(Exception.class);
    }
    @Test
    void testGetOrderByIdItsTrow() {
        when(orderRepository.findById(UUID.fromString("ds"))).thenReturn(Optional.of(new Order()));
        assertThatThrownBy(() -> orderService.getOrderById(UUID.fromString("ds")))
                .isInstanceOf(Exception.class);
    }
}
