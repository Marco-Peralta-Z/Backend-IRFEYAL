package com.irfeyal.modelo.dao.rolseguridad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.rolseguridad.Direccion;





public interface DireccionDAO extends CrudRepository<Direccion, Long>{
	Page<Direccion> findAll(Pageable pageable);

}
