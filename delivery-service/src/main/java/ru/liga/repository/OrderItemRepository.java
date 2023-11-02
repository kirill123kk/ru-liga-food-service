package ru.liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.model.OrderItem;

import java.util.List;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

    @Transactional(readOnly = true)
    @Query("SELECT i FROM OrderItem i WHERE i.orderId.id = :orderId")
        List<OrderItem> findByOrderId(@Param("orderId") Long orderId);
}
