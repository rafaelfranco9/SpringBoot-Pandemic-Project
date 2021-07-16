package com.franco.PandemicMetrics.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(
				"/images/**",
				"/css/**",
				"/flagImages/**"
		).permitAll()
		.antMatchers(
				"/",
				"/countries",
				"/country/countryData"
		).permitAll()
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll();
		
	}
	
}
