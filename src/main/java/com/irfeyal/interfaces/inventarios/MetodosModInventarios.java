package com.irfeyal.interfaces.inventarios;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.hibernate.exception.DataException;

public class MetodosModInventarios {
	
	public Date obtenerFechaActual() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		try {
			Date dataFormateada = formato.parse(dtf.format(LocalDateTime.now()));
			return dataFormateada;
			
		}catch(Exception dataException) {
			System.out.println("Error en fecha"+dataException);
			return null;
		}
	}

}
