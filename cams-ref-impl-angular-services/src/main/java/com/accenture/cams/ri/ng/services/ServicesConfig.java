package com.accenture.cams.ri.ng.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.accenture.cams.ri.ng.common.ApplicationMessages;

@Configuration
@EnableTransactionManagement
public class ServicesConfig {

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public ApplicationMessages applicationMessages() {
	return new ApplicationMessages();
    }

}
