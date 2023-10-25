package ru.liga.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.liga.model.RestaurantMenuItem;

public interface MenuItemRepository extends JpaRepository<RestaurantMenuItem,Long> {
}
