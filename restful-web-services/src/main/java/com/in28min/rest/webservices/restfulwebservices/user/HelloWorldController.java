package com.in28min.rest.webservices.restfulwebservices.user;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	private MessageSource messageSource;
	
	
public HelloWorldController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}


@GetMapping(path="/hello-world-internationalised")
public String helloWorldInternationalised() {
	
	//to get the locale from the header 
	Locale locale = LocaleContextHolder.getLocale();
	return  messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	//"Good morning";
}








}
