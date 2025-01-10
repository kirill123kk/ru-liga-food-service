package ru.liga.api;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.liga.model.Restaurant;

public interface RestaurantsRepository extends JpaRepository<Restaurant,Long> {
}
