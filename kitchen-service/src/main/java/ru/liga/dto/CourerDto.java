package ru.liga.dto;

import lombok.Data;

import javax.persistence.*;

@Data
public class CourerDto {

    private long id;

    private String phone;

    private String status;

    private String coordinats;

}
