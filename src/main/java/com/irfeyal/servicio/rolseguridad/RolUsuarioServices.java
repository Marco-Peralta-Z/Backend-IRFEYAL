package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.interfaz.RolUsuarioInterface;
import com.example.demo.models.dao.RolUsuarioDAO;
import com.example.demo.models.dao.TelefonoDAO;
import com.example.demo.models.entity.RolUsuario;
@Service
public class RolUsuarioServices implements RolUsuarioInterface{

	@Autowired
	  private RolUsuarioDAO rolusuariodao;

	@Override
	public List<RolUsuario> findAll() {
		// TODO Auto-generated method stub
		return (List<RolUsuario>)rolusuariodao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<RolUsuario> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return rolusuariodao.findAll(pageable);
	}

	@Override
	public RolUsuario findById(Long id) {
		// TODO Auto-generated method stub
		return rolusuariodao.findById(id).orElse(null);
	}

	@Override
	public RolUsuario saveRolUsuario(RolUsuario rolusuario) {
		// TODO Auto-generated method stub
		return rolusuariodao.save(rolusuario);
	}

	@Override
	public void deleteRolUsuario(Long id) {
		// TODO Auto-generated method stub
		rolusuariodao.deleteById(id);
	}
	  
	
	
	

}
