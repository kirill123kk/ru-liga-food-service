package ru.liga.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
@Slf4j
public class RoutingMQConfig {

    public static final String ORDER_TO_NOTIFICATION = "orderToNotificationQueue";

    public static final String ORDER_TO_KITCHEN = "orderToKitchenQueue";
    public static final String KITCHEN_TO_ORDER = "kitchenToOrderQueue";

    public static final String ORDER_TO_DELIVERY = "orderToDeliveryQueue";

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }



    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public Declarables newQueue() {
        Queue newOrderToKitchen = new Queue(ORDER_TO_KITCHEN, false);
        Queue kitchenToOrder = new Queue(KITCHEN_TO_ORDER, false);
        Queue orderToDelivery = new Queue(ORDER_TO_KITCHEN, false);

        DirectExchange directExchange = new DirectExchange("directExchange");

        return new Declarables(
                newOrderToKitchen, kitchenToOrder, orderToDelivery,
                directExchange,
                BindingBuilder.bind(newOrderToKitchen).to(directExchange).with(ORDER_TO_KITCHEN),
                BindingBuilder.bind(kitchenToOrder).to(directExchange).with(KITCHEN_TO_ORDER),
                BindingBuilder.bind(orderToDelivery).to(directExchange).with(ORDER_TO_DELIVERY)
        );
    }

}