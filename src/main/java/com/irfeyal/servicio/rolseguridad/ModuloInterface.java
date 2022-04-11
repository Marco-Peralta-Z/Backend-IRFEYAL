package com.irfeyal.servicio.rolseguridad;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.rolseguridad.Modulo;

public interface ModuloInterface {

public List<Modulo> findAll();
	
	public Page<Modulo> findAll(Pageable pageable);
	
	public Modulo findById(Long id);
	
	public Modulo saveModulo(Modulo modulo);
	
	public List<Modulo> deleteModulo (Long id);
}
