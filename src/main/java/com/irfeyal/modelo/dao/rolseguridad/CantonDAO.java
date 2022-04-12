package com.irfeyal.modelo.dao.rolseguridad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.rolseguridad.Canton;

public interface CantonDAO extends CrudRepository<Canton, Long> {
	Page<Canton> findAll(Pageable pageable);

}