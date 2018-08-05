package com.concretepage.app.spring4soap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);
		ctx.setServletContext(servletContext);
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(ctx);
		servlet.setTransformWsdlLocations(true);
		Dynamic dynamic = servletContext.addServlet("dispatcher", servlet);
		dynamic.addMapping("/soapws/*");
		dynamic.setLoadOnStartup(1);
		
		/*XmlWebApplicationContext appContext = new XmlWebApplicationContext();
		 *      appContext.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");
		 *
		 *      ServletRegistration.Dynamic dispatcher =
		 *        container.addServlet("dispatcher", new DispatcherServlet(appContext));
		 *      dispatcher.setLoadOnStartup(1);
		 *      dispatcher.addMapping("/");*/
	}

}
