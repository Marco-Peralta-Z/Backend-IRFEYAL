package com.irfeyal.servicio.rolseguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.rolseguridad.Direccion;



public interface DireccionInterface {

public List<Direccion> findAll();
	
	public Page<Direccion> findAll(Pageable pageable);
	
	public Direccion findById(Long id);
	
	public Direccion saveDireccion(Direccion direccion);
	
	public List<Direccion> deleteDireccion (Long id);
}
