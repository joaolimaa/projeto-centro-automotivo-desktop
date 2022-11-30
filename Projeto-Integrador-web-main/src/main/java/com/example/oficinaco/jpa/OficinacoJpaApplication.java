package com.example.oficinaco.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.faces.FactoryFinder;
import javax.faces.application.Application;
import javax.faces.application.ApplicationFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.jsf.el.SpringBeanFacesELResolver;

import com.example.oficinaco.jpa.jsf.PessoaControl;
import com.sun.faces.config.ConfigureListener;
import com.sun.faces.config.FacesInitializer;

@SpringBootApplication
public class OficinacoJpaApplication implements ServletContextInitializer{

	public static void main(String[] args) {
		SpringApplication.run(OficinacoJpaApplication.class, args);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
		servletContext.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", "true");

		servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
		servletContext.setInitParameter("facelets.DEVELOPMENT", "true");
		servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");

		Set<Class<?>> clazz = new HashSet<Class<?>>();

		clazz.add(OficinacoJpaApplication.class); 

		FacesInitializer facesInitializer = new FacesInitializer();
		facesInitializer.onStartup(clazz, servletContext);
	}

	@Bean
	public ServletListenerRegistrationBean<JsfApplicationObjectConfigureListener> jsfConfigureListener() {
		return new ServletListenerRegistrationBean<JsfApplicationObjectConfigureListener>(
				new JsfApplicationObjectConfigureListener());
	}


	static class JsfApplicationObjectConfigureListener extends ConfigureListener {

		@Override
		public void contextInitialized(ServletContextEvent sce) {
			super.contextInitialized(sce);

			ApplicationFactory factory = (ApplicationFactory) FactoryFinder.getFactory(FactoryFinder.APPLICATION_FACTORY);
			Application app = factory.getApplication();

			app.addELResolver(new SpringBeanFacesELResolver());
		}
	}	

}
