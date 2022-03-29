package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.models.entity.Empleado;

public interface IEmpleadoService {

	
public List<Empleado> findAll();
	
	public Page<Empleado> findAll(Pageable pageable);
	
	public Empleado findById(Long id);
	
	public Empleado save(Empleado estudiante);
	
	public void delete (Long id);
	
}
