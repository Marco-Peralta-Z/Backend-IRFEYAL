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
 * Si desea agregar mas paths puedo hacerlo segun su módulo por favor mantener el orden 
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
		.antMatchers("/asistencia/**").hasAnyRole("Administrador","Docente")
		//DOCUMENTOS ACADÉMICOS
		.antMatchers("/planunidades/**").hasAnyRole("Administrador","Coordinador academico", "Docente")
		.antMatchers("/unidades/**")	.hasAnyRole("Administrador","Coordinador academico", "Docente")
		//INVENTARIOS
		.antMatchers("/aprobacion/**")				.hasAnyRole("Administrador","Coordinador administrativo","Coordinador de desarrollo institucional")
		.antMatchers("/aprobacionkit/**")			.hasAnyRole("Administrador","Coordinador administrativo","Coordinador de desarrollo institucional")
		.antMatchers("/articulo/**")				.hasAnyRole("Administrador","Coordinador administrativo","Coordinador de desarrollo institucional")
		.antMatchers("/bajaarticulo/**")			.hasAnyRole("Administrador","Coordinador administrativo","Coordinador de desarrollo institucional")
		.antMatchers("/categoriarticulo/**")		.hasAnyRole("Administrador","Coordinador administrativo","Coordinador de desarrollo institucional")
		.antMatchers("/controlarticulo/**")			.hasAnyRole("Administrador","Coordinador administrativo","Coordinador de desarrollo institucional")
		.antMatchers("/detallebajaarticulo/**")		.hasAnyRole("Administrador","Coordinador administrativo","Coordinador de desarrollo institucional")
		.antMatchers("/detalleingresoarticulo/**")	.hasAnyRole("Administrador","Coordinador administrativo","Coordinador de desarrollo institucional")
		.antMatchers("/inventario/**")				.hasAnyRole("Administrador","Coordinador administrativo","Coordinador de desarrollo institucional")
		.antMatchers("/kit/**")						.hasAnyRole("Administrador","Coordinador administrativo","Coordinador de desarrollo institucional")
		.antMatchers("/modulolibro/**")		        .hasAnyRole("Administrador","Coordinador administrativo","Coordinador de desarrollo institucional")
		.antMatchers("/recepcionarticulo/**")		.hasAnyRole("Administrador","Coordinador administrativo","Coordinador de desarrollo institucional")
		.antMatchers("/salidaarticulo/**")			.hasAnyRole("Administrador","Coordinador administrativo","Coordinador de desarrollo institucional")
		//MATRICULA
		.antMatchers("/api/**")				        .hasAnyRole("Administrador","Secretaria")
		.antMatchers("/api/buscarEstudiante/**")	.hasAnyRole("Administrador","Secretaria")
		.antMatchers("/api/buscarEstudiantes/**")	.hasAnyRole("Administrador","Secretaria")
		.antMatchers("/api/historialMatricula/**")	.hasAnyRole("Administrador","Secretaria")
		.antMatchers("/api/matricula/**")	        .hasAnyRole("Administrador","Secretaria")
		.antMatchers("/api/sendMail/**")	        .hasAnyRole("Administrador","Secretaria")
		//PAGOS
		.antMatchers("/api/comprobante/**")			.hasAnyRole("Administrador","Secretaria")
		.antMatchers("/api/detalleComprobante/**")	.hasAnyRole("Administrador","Secretaria")
		.antMatchers("/api/tipoComprobante/**")		.hasAnyRole("Administrador","Secretaria")
		.antMatchers("/api/tipo_pago/**")			.hasAnyRole("Administrador","Secretaria")
		//PARAMETRIZACION
		.antMatchers("/area/**")		.hasAnyRole("Administrador","Coordinador administrativo", "Coordinador academico")
		.antMatchers("/asignatura/**")	.hasAnyRole("Administrador","Coordinador administrativo", "Coordinador academico")
		.antMatchers("/curso/**")		.hasAnyRole("Administrador","Coordinador administrativo", "Coordinador academico")
		.antMatchers("/horario/**")		.hasAnyRole("Administrador","Coordinador administrativo", "Coordinador academico")
		.antMatchers("/malla/**")		.hasAnyRole("Administrador","Coordinador administrativo", "Coordinador academico")
		.antMatchers("/modalidad/**")	.hasAnyRole("Administrador","Coordinador administrativo", "Coordinador academico")
		.antMatchers("/paralelo/**")	.hasAnyRole("Administrador","Coordinador administrativo", "Coordinador academico")
		.antMatchers("/periodo/**")		.hasAnyRole("Administrador","Coordinador administrativo", "Coordinador academico")
		.antMatchers("/tutor/**")		.hasAnyRole("Administrador","Coordinador administrativo", "Coordinador academico")
		//SECRETARIA
		.antMatchers("/api/documentos/**")			.hasAnyRole("Administrador","Secretaria")
		.antMatchers("/api/certificadoMatricula/**").hasAnyRole("Administrador","Secretaria")
		.antMatchers("/api/certificadoPromocion/**").hasAnyRole("Administrador","Secretaria")
		.antMatchers("/api/registroBitacora/**")	.hasAnyRole("Administrador","Secretaria")	
		//TUTORIAS:
		.antMatchers("/registro/**").hasAnyRole("Administrador","Docente")
		//ROL SEGURIDAD
		.antMatchers("/mapCanton/**")			.hasAnyRole("Administrador")
		.antMatchers("/mapCorreoElectronico/**").hasAnyRole("Administrador")
		.antMatchers("/mapDireccion/**")		.hasAnyRole("Administrador")
		.antMatchers("/mapEmpleado/**")			.hasAnyRole("Administrador")
		.antMatchers("/mapEmpresa/**")			.hasAnyRole("Administrador")
		.antMatchers("/mapExtension/**")		.hasAnyRole("Administrador")
		.antMatchers("/mapGenero/**")			.hasAnyRole("Administrador")
		.antMatchers("/mapModulo/**")			.hasAnyRole("Administrador")
		.antMatchers("/mapPais/**")				.hasAnyRole("Administrador")
		.antMatchers("/mapParroquia/**")		.hasAnyRole("Administrador")
		.antMatchers("/mapPersona/**")			.hasAnyRole("Administrador")
		.antMatchers("/mapProv/**")				.hasAnyRole("Administrador")
		.antMatchers("/mapTelefono/**")			.hasAnyRole("Administrador")
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
