package ru.liga.model;

import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@Table(name = "courers")
public class Courer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String phone;

    private String status;

    private String coordinats;

}
