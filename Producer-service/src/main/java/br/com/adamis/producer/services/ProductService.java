package br.com.adamis.producer.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import commons.contants.RabbitMQConstants;
import commons.dtos.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductService {

	private final RabbitTemplate rabbitTemplate;
	
	
	public void createProduct(ProductDTO productDTO) {
		
		log.info("Sending a message to Exchange: "+productDTO.toString());
		
		rabbitTemplate.convertAndSend(RabbitMQConstants.EXG_NAME_MARKETPLACE,RabbitMQConstants.RK_PRODUCT_LOG, productDTO);
		
	}
	
}
