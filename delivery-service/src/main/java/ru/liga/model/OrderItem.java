package ru.liga.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order orderId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_menu_item")
    private RestaurantMenuItem restaurantMenuItems;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Long quantity;

}
