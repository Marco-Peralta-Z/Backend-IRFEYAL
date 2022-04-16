package com.irfeyal.modelo.dao.matricula; 

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.matricula.Matricula;

public interface IMatriculaDao extends CrudRepository<Matricula, Long>{

	
	Page<Matricula> findAll(Pageable pageable);
}
