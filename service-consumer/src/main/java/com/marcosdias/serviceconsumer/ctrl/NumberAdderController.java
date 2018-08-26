package com.marcosdias.serviceconsumer.ctrl;

import java.text.MessageFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NumberAdderController {

	private Log log = LogFactory.getLog(NumberAdderController.class);

	@Value("${number.service.url}")
	private String numberServiceUrl;

	@GetMapping("/sum")
	public Long sum() {
		
		log.info("[ sum ] - Sum random numbers");
		
		long sum = 0;
		
		Integer[] numbers = requestRandomNumbers();
		
		for (int number : numbers) {
			sum += number;
		}
		
		log.info(MessageFormat.format("[ sum ] Final result [{0}]", sum));
		
		return sum;
	}

	private Integer[] requestRandomNumbers() {
		log.info("[ requestRandomNumbers ] - Request array of random number");

		ResponseEntity<Integer[]> responseEntity = new RestTemplate().getForEntity(numberServiceUrl, Integer[].class);
		Integer[] numbers = responseEntity.getBody();
		
		log.info(MessageFormat.format("[ sum ] - Numbers requesteds {0}", numbers.toString()));
		return numbers;
	}
}
