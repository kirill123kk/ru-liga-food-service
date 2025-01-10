package ru.liga.exception;

public class OrderServiceException extends RuntimeException {
    public OrderServiceException(String msg) {
        super(msg);
    }
}
