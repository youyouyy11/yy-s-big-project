package com.senmiao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.senmiao.filter.NoCacheFilter;
import com.telecom.common.error.ErrorHandlerFilter;
import com.telecom.security.login.SecurityFactory;
import com.telecom.security.login.model.Role;

@ComponentScan
@EnableAutoConfiguration
@EnableAsync
@EnableScheduling
public class Startup implements CommandLineRunner {

	Logger log = LoggerFactory.getLogger(Startup.class);

	@Bean
	public FilterRegistrationBean NoCacheReistration(){
		
		NoCacheFilter filter = new NoCacheFilter();
		FilterRegistrationBean registration = new FilterRegistrationBean();
		
		registration.setFilter(filter);
		registration.addUrlPatterns("*.html", "*.js", "*.css");
		
		return registration;
	}
	
	public void run(String... arg0) throws Exception {
		log.info("[senmiao-server]---------------------------");

		List<Role> roles = SecurityFactory.getInstance().getCurrentRoles();
		for (Role role : roles) {
			String urls = "";
			String sp = "";
			for (String url : role.getUrlPatterns()) {
				urls = sp + url;
				sp = ",";
			}
			log.debug("role id [{}] name [{}] url pattern [{}]", role.getId(), role.getName(), urls);
		}

	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Startup.class, args);

	}
}