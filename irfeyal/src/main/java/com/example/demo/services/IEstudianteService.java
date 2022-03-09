package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.models.entity.Estudiante;
import com.example.demo.models.entity.Persona;


public interface IEstudianteService {

	
	public List<Estudiante> findAll();
	
	public Page<Estudiante> findAll(Pageable pageable);
	
	public Estudiante findById(Long id);
	
	public Estudiante save(Estudiante estudiante);
	
	public void delete (Long id);
	
	public Persona savePersona(Persona persona);
	
}
