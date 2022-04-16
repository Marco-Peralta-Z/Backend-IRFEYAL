package com.irfeyal.interfaces.rolseguridad;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.rolseguridad.Persona;




public interface PersonaInterface {


public List<Persona> findAll();
	
	public Page<Persona> findAll(Pageable pageable);
	
	public Persona findById(Long id);
	
	public Persona savePersona(Persona persona);
	
	public void deletePersona (Long id);
}
