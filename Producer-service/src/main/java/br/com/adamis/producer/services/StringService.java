package br.com.adamis.producer.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import commons.contants.RabbitMQConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class StringService {

	private final RabbitTemplate rabbitTemplate;
	
	public void produce(String msg) {
		log.info("Received message: "+msg);
		rabbitTemplate.convertAndSend(RabbitMQConstants.EXG_NAME_MARKETPLACE, RabbitMQConstants.RK_PRODUCT_LOG, msg);				
	}
	
	
}
