package ru.liga.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "restaurants")
public class Restaurant {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String address;

    private String status;


}
