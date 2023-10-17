package ru.liga.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String phone;

    private String email;

    private String address;
}
