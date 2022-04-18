package com.irfeyal.servicio.rolseguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irfeyal.interfaces.rolseguridad.RolUsuarioInterface;
import com.irfeyal.modelo.dao.rolseguridad.RolUsuarioDAO;
import com.irfeyal.modelo.rolseguridad.RolUsuario;
@Service
public class RolUsuarioServices implements RolUsuarioInterface{

	@Autowired (required = true)
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
