package com.irfeyal.modelo.dao.rolseguridad;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.rolseguridad.Extension;



public interface ExtensionDAO extends CrudRepository<Extension, Long> {
	Page<Extension> findAll(Pageable pageable);
}
