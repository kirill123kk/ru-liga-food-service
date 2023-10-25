package ru.liga.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RoutingMQConfig {

    //Declarables - Класс объединящий в себе очереди, тип обменника и байдинги(связи)
    Logger logger = LoggerFactory.getLogger(RoutingMQConfig.class);
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
        return new RabbitTemplate(connectionFactory());
    }

    //объявляем очередь с именем queue1
    @Bean
    public Queue myQueue1() {
        return new Queue("queue1");
    }

    //объявляем контейнер, который будет содержать листенер для сообщений
   /* @Bean
    public SimpleMessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setQueueNames("queue1");
        //тут ловим сообщения из queue1
        container.setMessageListener(message -> logger.info("received from queue1 : " + new String(message.getBody())));
        return container;
    }*/
    /*@Bean
    public Declarables myQueue() {
        Queue queueDirectFirst = new Queue("myQueue1", false);
        Queue queueDirectSecond = new Queue("myQueue2", false);
        DirectExchange directExchange = new DirectExchange("directExchange");

        return new Declarables(queueDirectFirst, queueDirectSecond, directExchange,
                BindingBuilder.bind(queueDirectFirst).to(directExchange).with("job.it"),
                BindingBuilder.bind(queueDirectSecond).to(directExchange).with("job.other"));
    }*/

    /*@Bean
    public Declarables myQueueFanout() {
        Queue queueTopicFirst = new Queue("myTopicQueue1", false);
        Queue queueTopicSecond = new Queue("myTopicQueue2", false);
        TopicExchange topicExchange = new TopicExchange("topicExchange");

        return new Declarables(queueTopicFirst, queueTopicSecond, topicExchange,
                BindingBuilder.bind(queueTopicFirst).to(topicExchange).with("*.other"),
                BindingBuilder.bind(queueTopicSecond).to(topicExchange).with("*.it"));
    }*/
}