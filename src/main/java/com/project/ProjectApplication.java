package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

//@SpringBootApplication
//@PropertySource(value = { "WEB-INF/custom.properties" })
//public class AstroApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(AstroApplication.class, args);
//	}
//}
@SpringBootApplication
@PropertySource(value = { "WEB-INF/custom.properties" })
public class ProjectApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

}