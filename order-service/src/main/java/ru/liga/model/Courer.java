package ru.liga.model;

import io.swagger.v3.core.util.Json;
import lombok.Data;
import ru.liga.status.Status;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Courer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String phone;

    private Status status;

    private String coordinats;

}
