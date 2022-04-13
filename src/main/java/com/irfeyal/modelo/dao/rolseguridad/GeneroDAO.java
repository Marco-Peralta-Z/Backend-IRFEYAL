package com.irfeyal.modelo.dao.rolseguridad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.rolseguridad.Genero;

public interface GeneroDAO extends CrudRepository<Genero, Long> {
	Page<Genero> findAll(Pageable pageable);
}
