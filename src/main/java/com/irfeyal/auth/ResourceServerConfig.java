package com.irfeyal.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


/*
 * Para dar accesos a las del back  a los usuarios segun su rol
 * Configuracion de cors
 * 
 * 
 * Si desea agregar otro rol de hacerlo asi:  "nombre del rol de la bd" = 'estudiante'
 * Revisar el import.sql del back la tabla roles
 *
 * 
 * */

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	
	// lado del oauth
	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		//ASISTENCIA
		.antMatchers("/asistencia/**").hasAnyRole("Administrador","docente")
		//DOCUMENTOS ACADÉMICOS
		.antMatchers("/planunidades/**").hasAnyRole("Administrador","rectora", "docente")
		.antMatchers("/unidades/**")	.hasAnyRole("Administrador","rectora", "docente")
		//INVENTARIOS
		.antMatchers("/aprobacion/**")				.hasAnyRole("Administrador","coordinador administrativo","coordinador de desarrollo")
		.antMatchers("/articulo/**")				.hasAnyRole("Administrador","coordinador administrativo","coordinador de desarrollo")
		.antMatchers("/categoriarticulo/**")		.hasAnyRole("Administrador","coordinador administrativo","coordinador de desarrollo")
		.antMatchers("/detallebajaarticulo/**")		.hasAnyRole("Administrador","coordinador administrativo","coordinador de desarrollo")
		.antMatchers("/detalleingresoarticulo/**")	.hasAnyRole("Administrador","coordinador administrativo","coordinador de desarrollo")
		.antMatchers("/entregakit/**")				.hasAnyRole("Administrador","coordinador administrativo","coordinador de desarrollo")
		.antMatchers("/ingresokit/**")				.hasAnyRole("Administrador","coordinador administrativo","coordinador de desarrollo")
		.antMatchers("/inventario/**")				.hasAnyRole("Administrador","coordinador administrativo","coordinador de desarrollo")
		.antMatchers("/kit/**")						.hasAnyRole("Administrador","coordinador administrativo","coordinador de desarrollo")
		.antMatchers("/modulolibro/**")				.hasAnyRole("Administrador","coordinador administrativo","coordinador de desarrollo")
		.antMatchers("/recepcionarticulo/**")		.hasAnyRole("Administrador","coordinador administrativo","coordinador de desarrollo")
		.antMatchers("/salidaarticulo/**")			.hasAnyRole("Administrador","coordinador administrativo","coordinador de desarrollo")
		//MATRICULA
		.antMatchers("/api/**")				.hasAnyRole("Administrador","secretaria")
		.antMatchers("/api/matricula/**")	.hasAnyRole("Administrador","secretaria")
		//PAGOS
		.antMatchers("/api/comprobante/**")			.hasAnyRole("Administrador","secretaria")
		.antMatchers("/api/detalleComprobante/**")	.hasAnyRole("Administrador","secretaria")
		.antMatchers("/api/tipoComprobante/**")		.hasAnyRole("Administrador","secretaria")
		.antMatchers("/api/tipo_pago/**")			.hasAnyRole("Administrador","secretaria")
		//PARAMETRIZACION
		.antMatchers("/asignatura/**")	.hasAnyRole("Administrador","secretaria")
		.antMatchers("/curso/**")		.hasAnyRole("Administrador","secretaria")
		.antMatchers("/horario/**")		.hasAnyRole("Administrador","secretaria")
		.antMatchers("/malla/**")		.hasAnyRole("Administrador","secretaria")
		.antMatchers("/modalidad/**")	.hasAnyRole("Administrador","secretaria")
		.antMatchers("/paralelo/**")	.hasAnyRole("Administrador","secretaria")
		.antMatchers("/periodo/**")		.hasAnyRole("Administrador","secretaria")
		//SECRETARIA
		.antMatchers("/api/documentos/**")			.hasAnyRole("Administrador","secretaria")
		.antMatchers("/api/certificadoMatricula/**").hasAnyRole("Administrador","secretaria")
		.antMatchers("/api/certificadoPromocion/**").hasAnyRole("Administrador","secretaria")
		.antMatchers("/api/registroBitacora/**")	.hasAnyRole("Administrador","secretaria")
		//TUTORIAS:
		.antMatchers("/registro/**").hasAnyRole("Administrador","docente")
		//ROL SEGURIDAD
		.antMatchers("/mapCanton/**")			.hasAnyRole("Administrador", "secretaria")
		.antMatchers("/mapCorreoElectronico/**").hasAnyRole("Administrador", "secretaria")
		.antMatchers("/mapDireccion/**")		.hasAnyRole("Administrador", "secretaria")
		.antMatchers("/mapEmpleado/**")			.hasAnyRole("Administrador", "secretaria")
		.antMatchers("/mapEmpresa/**")			.hasAnyRole("Administrador", "secretaria")
		.antMatchers("/mapExtension/**")		.hasAnyRole("Administrador", "secretaria")
		.antMatchers("/mapGenero/**")			.hasAnyRole("Administrador", "secretaria")
		.antMatchers("/mapModulo/**")			.hasAnyRole("Administrador", "secretaria")
		.antMatchers("/mapPais/**")				.hasAnyRole("Administrador", "secretaria")
		.antMatchers("/mapParroquia/**")		.hasAnyRole("Administrador", "secretaria")
		.antMatchers("/mapPersona/**")			.hasAnyRole("Administrador", "secretaria")
		.antMatchers("/mapProv/**")				.hasAnyRole("Administrador", "secretaria")
		.antMatchers("/mapTelefono/**")			.hasAnyRole("Administrador", "secretaria")
		.antMatchers("/mapRol/**")				.hasRole("Administrador")
		.antMatchers("/mapRolUsuario/**")		.hasRole("Administrador")
		.antMatchers("/mapUsuario/**")			.hasRole("Administrador")
		.anyRequest().authenticated()
		.and().cors().configurationSource(corsConfigurationSource());
		
	}
	
	// Configuracion Cors para informacion cruzada
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200")); // permitir el dominio del cliente "angular"
		config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		config.setAllowCredentials(true); //permitimos credenciales
		config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization")); // permitimos las cabeceras
		
		// registramos configuracion del cors para todas las rutas del back
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		
		return source;
	}
	
	// filtro de cors y pasamos toda la configuracion anterior
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter( corsConfigurationSource() ));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
	
}
