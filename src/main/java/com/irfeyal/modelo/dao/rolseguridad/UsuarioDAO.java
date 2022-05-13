package com.irfeyal.modelo.dao.rolseguridad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.rolseguridad.Usuario;


public interface UsuarioDAO extends CrudRepository<Usuario, Long>{
	Page<Usuario> findAll(Pageable pageable);
	
		
	@Query (value="SELECT * FROM usuario WHERE usuario=?1 AND contrasenia=?2", nativeQuery = true) 
	 Usuario login (String usuario, String contrasenia);
	
	/*
	 * Search by user name 
	 * */
	
	public Usuario findByUsuario(String usuario);
	
	/*
	 * Buscamos usuario por cedula de la persona
	 * */

	@Query(value = "select u from Usuario u where u.empleado.persona.cedula = ?1")
	public Usuario findByCedulaPersona(String cedula);

	
}
