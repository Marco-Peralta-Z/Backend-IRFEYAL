package com.irfeyal.interfaces.rolseguridad;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.irfeyal.modelo.rolseguridad.Modulo;

public interface ModuloInterface {
	
public List<Modulo> findAll();
	
	public Page<Modulo> findAll(Pageable pageable);
	
	public Modulo findById(Long id);
	
	public Modulo saveModulo(Modulo modulo);
	
	public void deleteModulo (Long id);
}
