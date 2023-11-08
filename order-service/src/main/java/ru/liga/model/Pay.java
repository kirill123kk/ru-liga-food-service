package ru.liga.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_pay")
public class Pay {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private long id;

        @OneToOne( fetch = FetchType.LAZY)
        @JoinColumn(name = "order_id")
        private Order orderId;


        @Column(name = "pay_url")
        private String payUrl;


}
