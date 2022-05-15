package com.irfeyal.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	
	// lado del oauth
	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/api").permitAll()
		//ASISTENCIA
		.antMatchers("/asistencia/**").hasAnyRole("Administrador","estudiante","docente")
		//DOCUMENTOS ACADÉMICOS
		.antMatchers("/planunidades/**").hasAnyRole("Administrador","estudiante","rectora", "docente")
		.antMatchers("/unidades/**")	.hasAnyRole("Administrador","estudiante","rectora", "docente")
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
		.antMatchers("/mapCanton/**")			.hasRole("Administrador")
		.antMatchers("/mapCorreoElectronico/**").hasRole("Administrador")
		.antMatchers("/mapDireccion/**")		.hasRole("Administrador")
		.antMatchers("/mapEmpleado/**")			.hasRole("Administrador")
		.antMatchers("/mapEmpresa/**")			.hasRole("Administrador")
		.antMatchers("/mapExtension/**")		.hasRole("Administrador")
		.antMatchers("/mapGenero/**")			.hasRole("Administrador")
		.antMatchers("/mapModulo/**")			.hasRole("Administrador")
		.antMatchers("/mapPais/**")				.hasRole("Administrador")
		.antMatchers("/mapParroquia/**")		.hasRole("Administrador")
		.antMatchers("/mapPersona/**")			.hasRole("Administrador")
		.antMatchers("/mapProv/**")				.hasRole("Administrador")
		.antMatchers("/mapRol/**")				.hasRole("Administrador")
		.antMatchers("/mapRolUsuario/**")		.hasRole("Administrador")
		.antMatchers("/mapTelefono/**")			.hasRole("Administrador")
		.antMatchers("/mapUsuario/**")			.hasRole("Administrador")
		.anyRequest().authenticated()
		.and().cors().configurationSource(corsConfigurationSource());
		
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization")); // permitimos las cabeceras
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		
		return source;
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter( corsConfigurationSource() ));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
	
}
