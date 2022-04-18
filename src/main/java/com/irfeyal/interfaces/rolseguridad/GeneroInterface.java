package com.irfeyal.interfaces.rolseguridad;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.irfeyal.modelo.rolseguridad.Genero;




public interface GeneroInterface {
	
public List<Genero> findAll();
	
	public Page<Genero> findAll(Pageable pageable);
	
	public Genero findById(Long id);
	
	public Genero saveGenero(Genero genero);
	
	
	public void deleteGenero (Long id);
}
