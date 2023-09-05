package com.example.springboot;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
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

		String greeting = "Greetings from Spring Boot + Tanzu!!!";

		logger.debug("Exited greeting method. Total time: {} ms", System.currentTimeMillis() - start);

		return greeting;
	}

}

@Component
class SomeComponent {

	private final ApplicationContext applicationContext;

	public SomeComponent(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
		this.causeException();
	}

	public void causeException() {
		try {
			Object bean = applicationContext.getBean("nonExistingBeanName");
		}
		catch (NoSuchBeanDefinitionException ex) {
			// handle exception here
			System.out.println("Bean not found as expected.");
		}
	}

}
