package com.irfeyal.modelo.dao.rolseguridad;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.rolseguridad.Empleado;



public interface EmpleadoDAO extends CrudRepository<Empleado, Long>{
	
	Page<Empleado> findAll(Pageable pageable);
	
}
