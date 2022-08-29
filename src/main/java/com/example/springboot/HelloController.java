package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping("/")
	public String index() {
		Long start = System.currentTimeMillis();
		logger.debug("Entered greeting method");
		
		String  greeting = "Greetings from Spring Boot + VMware!!!";
		
		logger.debug("Exited greeting method. Total time: {} ms", System.currentTimeMillis()-start);

		return greeting;
	}
}