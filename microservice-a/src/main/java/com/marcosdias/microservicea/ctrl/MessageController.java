package com.marcosdias.microservicea.ctrl;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcosdias.microservicea.ApplicationConfiguration;

@RestController
public class MessageController {
	
	private Log log = LogFactory.getLog(RandomNumberController.class);

	@Autowired
	private ApplicationConfiguration configuration;

	@GetMapping("/message")
	public Map<String, String> defaultMessage() {
		
		log.info("[ defaultMessage ] - Return default messagem applied in application.properties");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", configuration.getMessage());
		
		log.info(MessageFormat.format("[ defaultMessage ] - Returning [{0}]", configuration.getMessage()));
		
		return map;
	}
}