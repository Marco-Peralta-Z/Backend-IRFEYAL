package com.irfeyal.interfaces.rolseguridad;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.irfeyal.modelo.rolseguridad.Parroquia;
@Service


public interface ParroquiaInterface {
	@Autowired (required=true)
public List<Parroquia> findAll();
	
	public Page<Parroquia> findAll(Pageable pageable);
	
	public Parroquia findById(Long id);
	
	public Parroquia saveParroquia(Parroquia parroquia);
	
	public void deleteParroquia (Long id);
}
