package com.irfeyal.interfaces.rolseguridad;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.rolseguridad.Usuario;


public interface UsuarioInterface {

public List<Usuario> findAll();
	
	public Page<Usuario> findAll(Pageable pageable);
	
	public Usuario findById(Long id);
	
	public Usuario findByUsuario(String usuario);
	
	public  Usuario Login(String usuario, String contrasena);
	
	public Usuario saveUsuario(Usuario usuario);
	
	public  List<Usuario> listAllUsuario();
	
	public void deleteUsuario (Long id);
	
	public  Usuario update(Long id_usuario, double nuevaAprobacion);
}
