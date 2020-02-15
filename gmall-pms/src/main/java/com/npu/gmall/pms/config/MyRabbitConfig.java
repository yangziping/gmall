package com.npu.gmall.pms.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyRabbitConfig {

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue createSkuStockQueue(){
        return new Queue("skuStockqueue",true,false,false);
    }

    @Bean
    public Exchange createSkuStockExchange(){
        return new DirectExchange("skuStockExchange",true,false,null);
    }

    @Bean
    public Binding createBinding(){
        return new Binding("skuStockqueue",Binding.DestinationType.QUEUE,"skuStockExchange","deleteSkuStock",null);
    }

}
