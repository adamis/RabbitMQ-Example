package br.com.adamis.consumer.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import commons.contants.RabbitMQConstants;
import commons.dtos.ProductDTO;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class ProductConsumer {

	@RabbitListener(queues = {RabbitMQConstants.RK_PRODUCT_LOG})
	public void consume(ProductDTO message) {
		log.info("Received Message: "+ message.toString());		
	}
	
}
