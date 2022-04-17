package com.irfeyal.modelo.dao.matricula;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.matricula.Estudiante;

public interface IEstudianteDao  extends CrudRepository<Estudiante, Long> {
	
	
	Page<Estudiante> findAll(Pageable pageable);

}
