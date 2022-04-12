package com.irfeyal.modelo.dao.rolseguridad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.rolseguridad.Usuario;


public interface UsuarioDAO extends CrudRepository<Usuario, Long>{
	Page<Usuario> findAll(Pageable pageable);
}
