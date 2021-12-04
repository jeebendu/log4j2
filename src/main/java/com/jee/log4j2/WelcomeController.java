package com.jee.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	private static final Logger logger = LogManager.getLogger(WelcomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public String welcome() {	
		
		logger.info("Welcome to Application Log4j2");
		return "Welcome to Application Log4j2";
	}

	

}