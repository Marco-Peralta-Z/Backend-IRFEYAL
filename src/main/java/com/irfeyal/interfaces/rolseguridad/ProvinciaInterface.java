package com.irfeyal.interfaces.rolseguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.irfeyal.modelo.rolseguridad.Provincia;


@Service

public interface ProvinciaInterface  {
	@Autowired (required=true)
	
public List<Provincia> findAll();
	
	public Page<Provincia> findAll(Pageable pageable);
	
	public Provincia findById(Long id);
	
	public Provincia saveProvincia(Provincia provincia);
	
	public void deleteProvincia (Long id);
}
