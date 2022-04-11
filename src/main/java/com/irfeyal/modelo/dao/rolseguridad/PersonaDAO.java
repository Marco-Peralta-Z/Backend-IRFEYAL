package com.irfeyal.modelo.dao.rolseguridad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.rolseguridad.Persona;



public interface PersonaDAO extends CrudRepository<Persona, Long> {
	Page<Persona> findAll(Pageable pageable);
}
