package com.irfeyal.modelo.dao.rolseguridad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.rolseguridad.Parroquia;


public interface ParroquiaDAO extends CrudRepository<Parroquia,Long>{
	Page<Parroquia> findAll(Pageable pageable);
}
