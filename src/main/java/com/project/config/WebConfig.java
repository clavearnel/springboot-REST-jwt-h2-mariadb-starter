package com.project.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 *  Configure the static resource path manually 
 * 
 */


@Configuration
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@ComponentScan(basePackages = { "com.project.maincontroller" })
public class WebConfig extends WebMvcConfigurerAdapter{
	
	private static final String[] RESOURCE_LOCATIONS = {
		"classpath:/META-INF/resources/", "classpath:/resources/",
		"classpath:/static/", "classpath:/public/" };
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/static/");
//		registry.addResourceHandler("/**").addResourceLocations("/WEB-INF/classes/css/");
//		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/static/");
//		registry.addResourceHandler("/**").addResourceLocations(RESOURCE_LOCATIONS);
    }
	
	 @Override
     public void addCorsMappings(CorsRegistry registry) {
		 registry.addMapping("/**").allowedMethods("OPTIONS", "GET", "POST", "PUT", "DELETE").allowedOrigins("*")
         .allowedHeaders("*");
     }
}