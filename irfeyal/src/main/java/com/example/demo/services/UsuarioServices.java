package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.dao.UsuarioDAO;
import com.example.demo.models.entity.Usuario;

@Service
public class UsuarioServices {

	@Autowired
	  private UsuarioServicesI usuarioInterface;


	

	public Usuario login(String username, String password) {
		// TODO Auto-generated method stub
		return usuarioInterface.login(username, password);
	}
	  
	
	


}
