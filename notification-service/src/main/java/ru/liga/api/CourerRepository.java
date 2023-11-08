package ru.liga.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.liga.model.Courer;

@Repository
public interface CourerRepository extends JpaRepository<Courer, Long> {

}
