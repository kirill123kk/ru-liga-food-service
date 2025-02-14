package ru.liga.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.model.Courer;
import ru.liga.model.Order;

import java.util.List;

@Repository
public interface CourerRepository extends JpaRepository<Courer, Long> {

}
