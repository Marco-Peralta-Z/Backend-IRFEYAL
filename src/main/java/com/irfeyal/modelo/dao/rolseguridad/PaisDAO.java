package com.irfeyal.modelo.dao.rolseguridad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.rolseguridad.Pais;



public interface PaisDAO  extends CrudRepository<Pais, Long>{
	Page<Pais> findAll(Pageable pageable);

}
