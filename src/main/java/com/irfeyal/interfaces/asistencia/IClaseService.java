package com.irfeyal.interfaces.asistencia;

import java.util.List;

import com.irfeyal.modelo.asistencia.Clase;

public interface IClaseService {
	public Clase save(Clase clase);
	public List<Clase> findAll();
	public List<Clase>mostrarfechas(Long idestudiante, Integer iddocente);
	
	
}
