package com.irfeyal.servicio.rolseguridad;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.irfeyal.interfaces.rolseguridad.UsuarioLoginInterface;
import com.irfeyal.modelo.dao.rolseguridad.UsuarioDAO;
import com.irfeyal.modelo.dao.rolseguridad.UsuarioLoginDAO2;
import com.irfeyal.modelo.rolseguridad.Telefono;
import com.irfeyal.modelo.rolseguridad.Usuario;
import com.irfeyal.modelo.rolseguridad.UsuarioLogin;

@Service
public class UsuarioLoginServices2 implements UsuarioLoginInterface{

	@Autowired (required = true)
	 private UsuarioLoginDAO2 usuariodao;
	
	@Override
	public Page<UsuarioLogin> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioLogin LoginUser(String usuario, String contrasena) {
		// TODO Auto-generated method stub
		return usuariodao.loginUser(usuario, contrasena);
	}

	
	


	

	

	
	

	

	

}
