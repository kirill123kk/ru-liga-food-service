package ru.liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.model.Courer;

import java.util.List;

@Repository
public interface CourerRepository extends JpaRepository<Courer, Long> {
    @Transactional(readOnly = true)
    @Query("select cuor from Courer cuor where cuor.status = :status")
    List<Courer> findOrderByStatus(@Param("status") String status);
}
