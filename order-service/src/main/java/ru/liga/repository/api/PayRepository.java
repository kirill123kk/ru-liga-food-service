package ru.liga.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.model.Pay;

@Repository
public interface PayRepository extends JpaRepository<Pay, Long> {
    @Transactional(readOnly = true)
    @Query("select pay from Pay pay where pay.id = :id")
    Pay findPayById(@Param("id") Long id);
}
