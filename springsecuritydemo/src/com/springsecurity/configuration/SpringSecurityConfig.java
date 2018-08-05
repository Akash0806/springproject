package com.springsecurity.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath:webSecurityConfig.xml" })
@ComponentScan("com.springsecuritydemo.restauthentication")
public class SpringSecurityConfig {
	
	public SpringSecurityConfig(){
		super();
	}

}
