package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**")
        .addResourceLocations("file:C:/ryoko/images/");
		registry.addResourceHandler("/temp-images/**")
        .addResourceLocations("file:/tmp/images/", "file:C:\\Users\\mryos\\AppData\\Local\\Temp\\");
	}
}
