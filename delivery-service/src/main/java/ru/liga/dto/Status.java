package ru.liga.dto;

public enum Status {
     OK (200),
     NotFound (404 ),
     InternalServerError(500);
     private int status;
    Status(int status) {
    this.status=status;
    }
}
