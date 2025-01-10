package ru.liga.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.liga.model.OrderItem;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
