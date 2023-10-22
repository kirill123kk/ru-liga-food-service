package ru.liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.model.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Transactional(readOnly = true)
    @Query("SELECT o FROM Order o WHERE o.courer.id = :courierId")
    List<Order> findOrdersByCourierId(@Param("courierId") Long courierId);

    @Modifying
    @Transactional
    @Query("UPDATE Order o SET o.status = :status WHERE o.id = :id")
    void updateStatus(@Param("id") Long id, @Param("status") String status);

    @Transactional
    @Modifying
    @Query("UPDATE Order o SET o.courer = (SELECT c FROM Courer c WHERE c.id = :courierId) WHERE o.id = :id")
    void updateCourier(@Param("id") Long id, @Param("courierId") Long courierId);

}
