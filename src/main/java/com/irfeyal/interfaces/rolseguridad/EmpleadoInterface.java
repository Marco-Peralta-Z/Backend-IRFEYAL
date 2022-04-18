package com.irfeyal.interfaces.rolseguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.irfeyal.modelo.rolseguridad.Empleado;

public interface EmpleadoInterface {

	
public List<Empleado> findAll();
	
	public Page<Empleado> findAll(Pageable pageable);
	
	public Empleado findById(Long id);
	
	public Empleado saveEmpleado(Empleado estudiante);
	
	public void deleteEmpleado (Long id);
	
}
