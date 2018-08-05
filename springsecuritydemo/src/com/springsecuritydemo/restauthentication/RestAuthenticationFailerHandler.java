package com.springsecuritydemo.restauthentication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
@Component
public class RestAuthenticationFailerHandler extends SimpleUrlAuthenticationFailureHandler {
	 
}
