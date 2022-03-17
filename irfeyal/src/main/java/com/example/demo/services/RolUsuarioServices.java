package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.RolUsuarioDAO;
import com.example.demo.models.entity.RolUsuario;
@Service
public class RolUsuarioServices implements RolUsuarioServiceI{

	@Autowired
	  private RolUsuarioDAO rolusuariodao;
	  
	
	
	@Override
	public List<RolUsuario> findAll() {
		// TODO Auto-generated method stub
		return (List<RolUsuario> ) rolusuariodao.findAll();
	}

	@Override
	public List<RolUsuario> saveRolUsuario() {
		// TODO Auto-generated method stub
		return (List<RolUsuario> ) rolusuariodao.findAll();
	}

	@Override
	public List<RolUsuario> deleteRolUsuario() {
		// TODO Auto-generated method stub
		return (List<RolUsuario> ) rolusuariodao.findAll();
	}

	@Override
	public List<RolUsuario> updateRolUsuario() {
		// TODO Auto-generated method stub
		return (List<RolUsuario> ) rolusuariodao.findAll();
	}

}
