package com.ecomm.beecasual.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;
import org.springframework.webflow.security.SecurityFlowExecutionListener;

@Configuration
public class WebFlowConfig extends AbstractFlowConfiguration {

	@Autowired
	private WebMvcConfig webMvcConfig;

	
	
	@Bean
	public FlowExecutor flowExecutor() {
		return getFlowExecutorBuilder(flowRegistry())
				
				.build();
	}

	@Bean
	public FlowDefinitionRegistry flowRegistry() {
		return getFlowDefinitionRegistryBuilder(flowBuilderServices()).setFlowBuilderServices(flowBuilderServices())
				.setBasePath("/WEB-INF")
				.addFlowLocation("/registration-flow.xml","reg")
				.addFlowLocation("/cart-flow.xml","cart").
				build();
	}

	@Bean
	public FlowBuilderServices flowBuilderServices() {
	    return getFlowBuilderServicesBuilder()
	    		.setViewFactoryCreator(mvcViewFactoryCreator()).setDevelopmentMode(true)		
	    		.build();
	}
	
	@Bean
	public MvcViewFactoryCreator mvcViewFactoryCreator() {
		MvcViewFactoryCreator factoryCreator = new MvcViewFactoryCreator();
		factoryCreator.setViewResolvers(Arrays.<ViewResolver>asList(this.webMvcConfig.ajaxUrlBasedViewResolver()));
		factoryCreator.setUseSpringBeanBinding(true);
		return factoryCreator;
	}
	
	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}

}