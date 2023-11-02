package com.tech.info.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WrapperConfig {
	
	@Bean
	public ModelMapper modelMaper() {
		return new ModelMapper();
	}

}
