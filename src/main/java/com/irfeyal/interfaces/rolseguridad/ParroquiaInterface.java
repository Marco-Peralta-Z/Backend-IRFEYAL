package com.irfeyal.interfaces.rolseguridad;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.rolseguridad.Parroquia;


public interface ParroquiaInterface {

public List<Parroquia> findAll();
	
	public Page<Parroquia> findAll(Pageable pageable);
	
	public Parroquia findById(Long id);
	
	public Parroquia saveParroquia(Parroquia parroquia);
	
	public void deleteParroquia (Long id);
}
