package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.dao.UsuarioDAO;
import com.example.demo.models.entity.Usuario;

@Service
public class UsuarioServices implements UsuarioServicesI{

	@Autowired
	  private UsuarioDAO usuariodao;

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario> ) usuariodao.findAll();
	}

	@Override
	public List<Usuario> saveUsuario() {
		// TODO Auto-generated method stub
		return (List<Usuario> ) usuariodao.findAll();
	}

	@Override
	public List<Usuario> deleteUsuario() {
		// TODO Auto-generated method stub
		return (List<Usuario> ) usuariodao.findAll();
	}

	@Override
	public List<Usuario> updateUsuario() {
		// TODO Auto-generated method stub
		return (List<Usuario> ) usuariodao.findAll();
	}
	  
	
	


}
