package com.qudi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RunSpringBoot  {

	
	public static void main(String[] args) {
		SpringApplication.run(RunSpringBoot.class, args);
	}

	/*@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);

		registry.addResourceHandler("/**").addResourceLocations("/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}*/
	/*
	 * protected SpringApplicationBuilder configure(SpringApplicationBuilder
	 * builder) { return builder.sources(this.getClass()); }
	 */

}
