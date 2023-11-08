package ru.liga.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.model.Courer;
import ru.liga.model.Order;
import ru.liga.model.Status;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Transactional(readOnly = true)
    @Query("select ord from Order ord where ord.status = :status")
    List<Order> findOrderByStatus(@Param("status") String status);

    @Modifying
    @Transactional
    @Query("UPDATE Order o SET o.status = :status,o.courer =:courierId WHERE o.id = :id")
    void updateStatus(@Param("id") UUID id, @Param("status") Status status,@Param("courierId") Courer courierId);

}
