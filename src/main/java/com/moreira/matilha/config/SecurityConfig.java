package com.moreira.matilha.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/public").permitAll() // URLs públicas
				.antMatchers("/admin/**").hasRole("ADMIN") // URLs restritas para usuários com a role ADMIN
				.anyRequest().authenticated() // Todas as outras URLs requerem autenticação
				.and().formLogin().permitAll() // Configuração de login
				.and().logout().permitAll(); // Configuração de logout
		
		http.csrf().disable();
				
	}
}
