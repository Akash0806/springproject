package com.concretepage.app.spring4soap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
@Configuration
@EnableWs
@ComponentScan("com.concretepage.app.spring4soap")
public class AppConfig extends WsConfigurerAdapter {
	@Bean(name = "students")
	public DefaultWsdl11Definition  getDefaultWsdl11Definition (XsdSchema studentsSchema){
		DefaultWsdl11Definition defaultWsdl11Definition=new DefaultWsdl11Definition();
		defaultWsdl11Definition.setSchema(studentsSchema);
		defaultWsdl11Definition.setPortTypeName("StudentPort");
		defaultWsdl11Definition.setLocationUri("/soapws");
		defaultWsdl11Definition.setTargetNamespace("http://concretepage.com/soap");
		return defaultWsdl11Definition;
	}
	
	@Bean
	public XsdSchema studentsSchema() {
		return new SimpleXsdSchema(new ClassPathResource("/resources/students.xsd"));
	}

}
