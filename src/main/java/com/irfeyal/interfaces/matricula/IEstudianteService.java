package com.irfeyal.interfaces.matricula;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.matricula.Estudiante;
import com.irfeyal.modelo.rolseguridad.Persona;


public interface IEstudianteService {
	
	public List<Estudiante> findAll();
	
	public List<Persona> findAllPersonas();
	
	public Page<Estudiante> findAll(Pageable pageable);
	
	public Estudiante findById(Long id);
	
	public Estudiante save(Estudiante estudiante);
	
	public void delete (Long id);
	
	public Estudiante findByCedula(String cedula);
	
}
