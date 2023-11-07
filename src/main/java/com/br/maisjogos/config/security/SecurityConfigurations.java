package com.br.maisjogos.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;



@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
	@Autowired
	SecurityFIlterCliente securityFIlterCliente;
	@Autowired
	SecurityFilterDev securityFilterDev;
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		return httpSecurity
				.csrf(csrf -> csrf.disable())
				.cors(cors -> {
	                cors.configurationSource(corsConfigurationSource());
	            })
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(HttpMethod.POST, "auth/login/dev").permitAll()
						.requestMatchers(HttpMethod.POST, "auth/cadastro/dev").permitAll()
						.requestMatchers(HttpMethod.GET, "auth/desenvolvedor").permitAll()
						.requestMatchers(HttpMethod.GET, "auth/dev/{id}").permitAll()
						.requestMatchers(HttpMethod.POST, "auth/login").permitAll()
						.requestMatchers(HttpMethod.POST, "auth/cadastro").permitAll()
						.requestMatchers(HttpMethod.GET, "auth/cliente").permitAll()
						.requestMatchers(HttpMethod.GET, "auth/{id}").permitAll()
						.requestMatchers(HttpMethod.POST, "/jogos").permitAll()
						.requestMatchers(HttpMethod.GET, "/jogos").permitAll()
						.requestMatchers(HttpMethod.PATCH, "/jogos/{id}").permitAll()
						.requestMatchers(HttpMethod.POST, "/release-avatares").permitAll()
						.requestMatchers(HttpMethod.GET, "/release-avatares").permitAll()
						.requestMatchers(HttpMethod.PATCH, "/release-avatares/{id}").permitAll()
						.requestMatchers(HttpMethod.POST, "/review").permitAll()
						.requestMatchers(HttpMethod.GET, "/review").permitAll()
						.requestMatchers(HttpMethod.GET, "/review/{id}").permitAll()
						.requestMatchers(HttpMethod.PUT, "/review/{id}").permitAll()
						.requestMatchers(HttpMethod.DELETE, "/review/{id}").permitAll()
						.anyRequest().authenticated()
				)
				
				.addFilterBefore(securityFIlterCliente, UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(securityFilterDev, UsernamePasswordAuthenticationFilter.class)
				.build()
				;
	}
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.addAllowedOrigin("http://localhost:5173"); 
	    configuration.addAllowedMethod("*"); 
	    configuration.addAllowedHeader("*"); 
	    configuration.setAllowCredentials(true);
	    UrlBasedCorsConfigurationSource source = new 
	     UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
		return authenticationConfiguration.getAuthenticationManager();
			
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
		
	
}
