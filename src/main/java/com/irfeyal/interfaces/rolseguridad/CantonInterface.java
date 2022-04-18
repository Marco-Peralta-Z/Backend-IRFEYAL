package com.irfeyal.interfaces.rolseguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.rolseguridad.Canton;




public interface CantonInterface {
	
public List<Canton> findAll();

	public Page<Canton> findAll(Pageable pageable);
	
	public Canton findById(Long id);
	
    public Canton  saveCanton(Canton canton);
	
	public void deleteCanton (Long id);
}
