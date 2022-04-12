package com.irfeyal.modelo.dao.rolseguridad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.rolseguridad.Telefono;

public interface TelefonoDAO extends CrudRepository<Telefono, Long> {
	Page<Telefono> findAll(Pageable pageable);
}
