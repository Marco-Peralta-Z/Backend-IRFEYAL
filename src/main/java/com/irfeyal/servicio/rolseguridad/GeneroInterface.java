package com.irfeyal.servicio.rolseguridad;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.rolseguridad.Genero;





public interface GeneroInterface {
	

public List<Genero> findAll();
	
	public Page<Genero> findAll(Pageable pageable);
	
	public Genero findById(Long id);
	
	public Genero saveGenero(Genero genero);
	
	public List<Genero> deleteGenero (Long id);
}
