package com.irfeyal.interfaces.rolseguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.irfeyal.modelo.rolseguridad.Telefono;
 
public interface TelefonoInterface {

 

public List<Telefono> findAll();
	
	public Page<Telefono> findAll(Pageable pageable);
	
	public Telefono findById(Long id);
	
	public Telefono saveTelefono(Telefono telefono);
	
	public void deleteTelefono (Long id);
}
