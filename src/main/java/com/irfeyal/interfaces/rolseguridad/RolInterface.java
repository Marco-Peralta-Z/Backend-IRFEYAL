package com.irfeyal.interfaces.rolseguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.rolseguridad.Rol;

public interface RolInterface {
	

public List<Rol> findAll();
	
	public Page<Rol> findAll(Pageable pageable);
	
	public Rol findById(Long id);
	
	public Rol saveRol(Rol rol);
	
	public void deleteRol (Long id);

}
