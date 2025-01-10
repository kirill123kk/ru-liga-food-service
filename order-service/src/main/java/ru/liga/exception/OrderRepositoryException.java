package ru.liga.exception;

public class OrderRepositoryException extends RuntimeException {
    public OrderRepositoryException(String msg) {
        super(msg);
    }
}
