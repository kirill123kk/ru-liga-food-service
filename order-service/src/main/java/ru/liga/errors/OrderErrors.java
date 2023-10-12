package ru.liga.errors;

public class OrderErrors   extends RuntimeException{
    public OrderErrors(String msg) {
        super(msg);
    }
}
