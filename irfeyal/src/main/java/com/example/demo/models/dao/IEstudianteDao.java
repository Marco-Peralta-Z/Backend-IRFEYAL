package com.example.demo.models.dao;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Estudiante;


public interface IEstudianteDao extends CrudRepository<Estudiante, Long> {
	
	
	Page<Estudiante> findAll(Pageable pageable);
	
	

}
