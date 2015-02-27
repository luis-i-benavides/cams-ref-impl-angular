package com.accenture.cams.ri.ng;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceConfig {

    @Bean
    Mapper mapper() {
	return new DozerBeanMapper();
    }

}
