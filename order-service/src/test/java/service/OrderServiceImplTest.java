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
    @Test
    void testSetOrder() {
    ReceiptDto receiptDto = new ReceiptDto();
    receiptDto.setRestrauntId(1L);
    receiptDto.setMenuItemDto(Arrays.asList(new MenuItemDto()));
    when(customerRepository.findById(1L)).thenReturn(Optional.of(new Customer()));
    when(restaurantsRepository.findById(1L)).thenReturn(Optional.of(new Restaurant()));
    when(menuItemRepository.findById(anyLong())).thenReturn(Optional.of(new RestaurantMenuItem()));
    UrlDto urlDto = orderService.setOrder(1L, receiptDto);
    assertNotNull(urlDto);
    assertNotNull(urlDto.getId());
    assertNotNull(urlDto.getSecretPaymentUrl());
    assertNotNull(urlDto.getEstimatedTimeOfArrival());
    }
    @Test
    void testPayForOrder() {
    UUID orderId = UUID.randomUUID();
    String paymentUrl = "http://" + orderId;
    Order order = new Order();
    order.setId(orderId);
    order.setStatus(Status.Processed.toString());
    Pay pay = new Pay();
    pay.setPayUrl(paymentUrl);
    order.setPay(pay);
    when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));
    orderService.payForOrder(orderId, paymentUrl);
    verify(orderRepository).updateStatus(orderId, Status.Paid.toString(), null);
    verify(rabbitService).sendMessage(any(OrderMessDto.class), eq(RoutingMQConfig.ORDER_TO_NOTIFICATION));
    }
    @Test
    void testUpdateOrderById() {
    UUID orderId = UUID.randomUUID();
    RabbitStatusDto rabbitStatusDto = new RabbitStatusDto();
    rabbitStatusDto.setStatus(Status.Paid);
    rabbitStatusDto.setCourierId(1L);
    orderService.updateOrderById(orderId, rabbitStatusDto);
    verify(orderRepository).updateStatus(orderId, Status.Paid.toString(), 1L);
    }
    @Test
    void testGetOrders() {
    List<Order> orderList = Arrays.asList(new Order(), new Order());
    when(orderRepository.findAll()).thenReturn(orderList);
    List<OrderDto> orderDtoList = orderService.getOrders();
    assertNotNull(orderDtoList);
    assertEquals(orderList.size(), orderDtoList.size());
    }
}
