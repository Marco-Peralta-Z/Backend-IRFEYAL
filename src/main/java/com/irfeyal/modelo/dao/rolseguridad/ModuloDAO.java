package com.irfeyal.modelo.dao.rolseguridad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.rolseguridad.Modulo;



public interface ModuloDAO extends CrudRepository<Modulo, Long> {
	Page<Modulo> findAll(Pageable pageable);

}
