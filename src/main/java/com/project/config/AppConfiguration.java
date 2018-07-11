package com.project.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="app")
public class AppConfiguration {
	
	private String name;
	private String defaultToken;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDefaultToken() {
		return defaultToken;
	}

	public void setDefaultToken(String defaultToken) {
		this.defaultToken = defaultToken;
	}
	
}
