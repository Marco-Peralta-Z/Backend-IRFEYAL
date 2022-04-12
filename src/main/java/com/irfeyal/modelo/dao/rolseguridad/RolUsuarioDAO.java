package com.irfeyal.modelo.dao.rolseguridad;

import org.springframework.data.domain.Page;
import com.irfeyal.modelo.rolseguridad.RolUsuario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface RolUsuarioDAO extends CrudRepository<RolUsuario, Long> {
	Page<RolUsuario> findAll(Pageable pageable);
}
