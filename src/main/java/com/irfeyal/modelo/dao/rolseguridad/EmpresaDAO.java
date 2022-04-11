package com.irfeyal.modelo.dao.rolseguridad;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.rolseguridad.Empresa;


public interface EmpresaDAO extends CrudRepository<Empresa, Long> {
	Page<Empresa> findAll(Pageable pageable);
	
	
}
