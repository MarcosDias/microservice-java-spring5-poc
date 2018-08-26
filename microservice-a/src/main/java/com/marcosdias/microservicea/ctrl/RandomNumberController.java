package com.marcosdias.microservicea.ctrl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomNumberController {
	
  private Log log = LogFactory.getLog(RandomNumberController.class);
  
  @GetMapping("/random")
  public List<Integer> random() {
	  
	log.info("[ random ] Get array with five random number!");
	  
    List<Integer> numbers = new ArrayList<Integer>();
    
    for (int i = 1; i <= 5; i++) {
      numbers.add(generateRandomNumber());
    }
    
    log.info(MessageFormat.format("[ random ] Returning {0}", numbers));
    
    return numbers;
  }
  
  private int generateRandomNumber() {
    return (int) (Math.random() * 1000);
  }
  
}
