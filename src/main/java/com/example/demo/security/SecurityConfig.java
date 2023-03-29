package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf().disable().addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeHttpRequests((requests) -> requests.requestMatchers("/users/listUsers").hasRole("ROLE_ADMIN").requestMatchers("/api/admin/**").hasRole("ADMIN")
						.requestMatchers("/api/user/**").hasRole("ROLE_USER").requestMatchers("/api/all/**")
						.hasAnyRole("ROLE_ADMIN", "ROLE_USER").requestMatchers("/**").permitAll().anyRequest().authenticated())
				.formLogin((form) -> form.loginPage("/auth/login").defaultSuccessUrl("/users/listUsers").permitAll())
				.logout((logout) -> logout.permitAll().logoutUrl("/auth/logout")
						.logoutSuccessUrl("/auth/login?logout"));
		return http.build();
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}
