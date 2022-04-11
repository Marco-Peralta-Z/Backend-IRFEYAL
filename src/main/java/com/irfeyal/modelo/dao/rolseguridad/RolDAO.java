package com.irfeyal.modelo.dao.rolseguridad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.rolseguridad.Rol;





public interface RolDAO extends CrudRepository<Rol, Long> {
	Page<Rol> findAll(Pageable pageable);
}
