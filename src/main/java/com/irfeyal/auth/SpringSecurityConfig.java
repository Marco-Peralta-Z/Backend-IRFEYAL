package com.irfeyal.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
 * 
 * Configuración de seguridad del springboot
 * 
 * */

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService usuariosService;
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	// Pasamos userDatails y el tipo de cifrado a usar
	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService( this.usuariosService ).passwordEncoder( passwordEncoder() );
	}
	
	// configuracion http 
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	// lado de spring
	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.anyRequest().authenticated() // todas las rutas necesitan autentificacion
		.and()
		.csrf().disable() // quitamos la validacion de formularios
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // quitamos el manejo de session
		
	}
	
	
}
