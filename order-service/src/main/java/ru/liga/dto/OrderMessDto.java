package ru.liga.dto;

import lombok.Data;

import ru.liga.model.*;


import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class OrderMessDto extends Order {


        private UUID id;


        private Customer customerId;


        private Restaurant restaurantId;


        private Courer courer;


        private List<OrderItem> orderItems;


        private Pay pay;

        private String status;


        private Date timestamp;


}
