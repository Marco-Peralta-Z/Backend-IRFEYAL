package com.irfeyal.modelo.dao.rolseguridad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.rolseguridad.Usuario;


public interface UsuarioDAO extends CrudRepository<Usuario, Long>{
	Page<Usuario> findAll(Pageable pageable);
	
	/*
	 * Search by user name and state in true
	 * */
	
	public Usuario findByUsuarioAndEstUsuario(String usuario, Boolean estUsuario);
	
	@Query (value="SELECT * FROM usuario WHERE usuario=?1 AND contrasenia=?2", nativeQuery = true) 
	 Usuario login (String usuario, String contrasenia);
	
	
}
