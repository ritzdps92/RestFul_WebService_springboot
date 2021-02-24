package com.ritesh.rest.webServices.restfulwebservices.helloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(method = RequestMethod.GET, path= "/hello-world")
	public String helloWorld() {
		return "Hello World!!";
	}
	
	@RequestMapping(method = RequestMethod.GET, path= "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		HelloWorldBean hel = new HelloWorldBean("HelloWorldBeanMessage");
		return hel;
	}
	
	
	@GetMapping(path = "hello-world-internationalized")
//	public String helloWorldInternationalized(@RequestHeader(name="Accept-language", required = false)Locale locale) {
//		return messageSource.getMessage("good.morning.message",null, locale);
//	}
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}

}
