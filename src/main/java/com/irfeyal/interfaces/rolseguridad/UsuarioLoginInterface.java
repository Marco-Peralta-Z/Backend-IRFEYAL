package com.irfeyal.interfaces.rolseguridad;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.irfeyal.modelo.rolseguridad.Usuario;
import com.irfeyal.modelo.rolseguridad.UsuarioLogin;


public interface UsuarioLoginInterface {

//public List<UsuarioLogin> LoginUser(String usuario, String contrasena);
	
	public Page<UsuarioLogin> findAll(Pageable pageable);
	
//	public Usuario findById(Long id);
	
	public  UsuarioLogin LoginUser(String usuario, String contrasena);
	
//	public Usuario saveUsuario(UsuarioLogin usuario);
	
	//public  List<UsuarioLogin> listAllUsuario();
	
	//public void deleteUsuario (Long id);
	
	//public  Usuario update(Long id_usuario, double nuevaAprobacion);
}
