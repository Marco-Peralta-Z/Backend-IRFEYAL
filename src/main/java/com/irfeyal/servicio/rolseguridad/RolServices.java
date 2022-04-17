package com.irfeyal.servicio.rolseguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irfeyal.interfaces.rolseguridad.RolInterface;
import com.irfeyal.modelo.dao.rolseguridad.RolDAO;
import com.irfeyal.modelo.rolseguridad.Rol;


@Service
public class RolServices implements RolInterface{
	

	@Autowired
  private RolDAO roldao;

	@Override
	public List<Rol> findAll() {
		// TODO Auto-generated method stub
		return (List<Rol>) roldao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Rol> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return roldao.findAll(pageable);
	}

	@Override
	public Rol findById(Long id) {
		// TODO Auto-generated method stub
		return roldao.findById(id).orElse(null);
	}

	@Override
	public Rol saveRol(Rol rol) {
		// TODO Auto-generated method stub
		return roldao.save(rol);
	}

	@Override
	public void deleteRol(Long id) {
		// TODO Auto-generated method stub
		roldao.deleteById(id);
	}
  

	
}
