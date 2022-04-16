package com.irfeyal.interfaces.matricula;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.matricula.Estudiante;


public interface IEstudianteService {
	
	public List<Estudiante> findAll();
	
	public Page<Estudiante> findAll(Pageable pageable);
	
	public Estudiante findById(Long id);
	
	public Estudiante save(Estudiante estudiante);
	
	public void delete (Long id);
	
}
