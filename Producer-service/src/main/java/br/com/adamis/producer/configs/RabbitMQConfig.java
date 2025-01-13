package br.com.adamis.producer.configs;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	@Value("${spring.application.name}")
	private String serverName;
	
//	@Value("${spring.rabbitmq.host}")
//	private String host;	
//	
//	@Value("${spring.rabbitmq.username}")
//	private String username;
//	
//	@Value("${spring.rabbitmq.password}")
//	private String password;
	
	
//	@Bean
//	public Queue queue() {
//		return new Queue(RabbitMQConstants.QUEUE_PRODUCT_LOG, false, false, false);
//	}
//	
//	
//	@Bean
//	public DirectExchange directExchange() {
//		return new DirectExchange(RabbitMQConstants.EXG_NAME_MARKETPLACE, false, false);
//	}
//	
//	
//	@Bean
//	public Binding binding() {
//		return BindingBuilder
//				.bind(queue())
//				.to(directExchange())
//				.with(RabbitMQConstants.RK_PRODUCT_LOG)
//				;
//		
//	}
	
	
	/**
	 * Função para colocar o nome da aplicação na conexao
	 * @return CachingConnectionFactory
	 */
	@Bean
    public CachingConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setConnectionNameStrategy(factory -> serverName);
        return connectionFactory;
    }
	
}
