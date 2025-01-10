package ru.liga.model;

public enum Status {

    Processed("Обрабатываеться"),
    Paid("оплачен"),
    Prepare("готовят"),
    Cooked("приготовлен"),
    Delivered("доставляется"),
    ACTIVE("активен"),
    COMPLETE("завершен"),
    DENIED( "отменен");
    Status(String s) {
    }
}
