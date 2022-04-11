package com.irfeyal.servicio.rolseguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.irfeyal.modelo.rolseguridad.Usuario;


public interface UsuarioInterface {


public List<Usuario> findAll();
	
	public Page<Usuario> findAll(Pageable pageable);
	
	public Usuario findById(Long id);
	
	public Usuario saveUsuario(Usuario usuario);
	
	public void deleteUsuario (Long id);
}
