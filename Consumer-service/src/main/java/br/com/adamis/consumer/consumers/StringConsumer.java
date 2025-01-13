package br.com.adamis.consumer.consumers;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class StringConsumer {

//	@RabbitListener(queues = {"product.log"})
//	public void consume(String message) {
//		log.info("Consumer received a message: "+ message);
//	}
	
}
