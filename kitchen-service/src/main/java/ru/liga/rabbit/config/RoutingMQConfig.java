package ru.liga.rabbit.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
@Slf4j
public class RoutingMQConfig {
    public static final String ORDER_TO_KITCHEN = "orderToKitchenQueue";
    public static final String KITCHENTONOTIFICATIONQUEUE = "kitchenToNotification";

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
    public Declarables kitchenToNotification() {


        Queue kitchenAcceptToNotification = new Queue(KITCHENTONOTIFICATIONQUEUE, false);


        DirectExchange directExchange = new DirectExchange("directExchange");

        return new Declarables(
                kitchenAcceptToNotification,
                directExchange,
                BindingBuilder.bind(kitchenAcceptToNotification).to(directExchange).with(KITCHENTONOTIFICATIONQUEUE)
        );
    }

}