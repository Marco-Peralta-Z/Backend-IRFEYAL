package com.irfeyal.modelo.dao.rolseguridad;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.rolseguridad.Empleado;



public interface EmpleadoDAO extends CrudRepository<Empleado, Long>{
	
	Page<Empleado> findAll(Pageable pageable);
	@Query (value = "select e from Empleado e where e.persona.cedula like %?1%")
	public List<Empleado> findAllEmpleadosByCedula(String cedula);
	
}
