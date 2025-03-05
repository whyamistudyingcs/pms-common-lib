package com.fdm.pmscommon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

@Configuration
public class RabbitMQConfig {
    public static final String TRADE_QUEUE = "tradeQueue";
    public static final String TRADE_EXCHANGE = "tradeExchange";
    public static final String TRADE_ROUTING_KEY = "tradeRoutingKey";

    @Bean
    public Queue tradeQueue() {
        return new Queue(TRADE_QUEUE);
    }
    
    @Bean
    public TopicExchange tradeExchange() {
        return new TopicExchange(TRADE_EXCHANGE);
    }

    @Bean
    public Binding tradeBinding(Queue tradeQueue, TopicExchange tradeExchange) {
        return BindingBuilder.bind(tradeQueue).to(tradeExchange).with(TRADE_ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
