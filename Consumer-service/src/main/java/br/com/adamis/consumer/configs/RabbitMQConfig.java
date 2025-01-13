package br.com.adamis.consumer.configs;

import java.util.Collections;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${spring.application.name}")
    private String serverName;


    /**
     * Função para colocar o nome da aplicação na conexao
     *
     * @return CachingConnectionFactory
     */
    @Bean
    public CachingConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setConnectionNameStrategy(factory -> serverName);
        return connectionFactory;
    }

    @Bean
    public SimpleMessageConverter messageConverter() {
        SimpleMessageConverter converter = new SimpleMessageConverter();
        // Add commons.dtos.ProductDTO to the allowed list for deserialization
        converter.setAllowedListPatterns(Collections.singletonList("commons.dtos.*"));
        return converter;
    }
}