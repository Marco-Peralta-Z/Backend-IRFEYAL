package com.irfeyal.interfaces.rolseguridad;

import java.util.List;
 
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; 

import com.irfeyal.modelo.rolseguridad.Provincia;


 

public interface ProvinciaInterface  {
 
	
public List<Provincia> findAll();
	
	public Page<Provincia> findAll(Pageable pageable);
	
	public Provincia findById(Long id);
	
	public Provincia saveProvincia(Provincia provincia);
	
	public void deleteProvincia (Long id);
}
