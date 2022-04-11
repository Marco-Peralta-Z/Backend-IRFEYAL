package com.irfeyal.servicio.rolseguridad;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.rolseguridad.Pais;


public interface PaisInterface  {


public List<Pais> findAll();
	
	public Page<Pais> findAll(Pageable pageable);
	
	public Pais findById(Long id);
	
	public Pais savePais(Pais pais);
	
	public List<Pais> deletePais (Long id);
}

