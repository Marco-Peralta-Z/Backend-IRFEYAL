package com.irfeyal.servicio.rolseguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irfeyal.modelo.dao.rolseguridad.CantonDAO;
import com.irfeyal.modelo.rolseguridad.Canton;
import com.irfeyal.interfaces.rolseguridad.CantonInterface;



@Service
public class CantonService implements CantonInterface {
	
	@Autowired (required = true)
	  private CantonDAO cantdao;

	@Override
	public List<Canton> findAll() {
		// TODO Auto-generated method stub
		return (List<Canton>)cantdao.findAll();
	}

	@Override
	public Canton saveCanton(Canton canton) {
		// TODO Auto-generated method stub
		return cantdao.save(canton);
	}

	@Override
	public Canton findById(Long id) {
		// TODO Auto-generated method stub
		return cantdao.findById(id).orElse(null);
	}

	@Override

	@Transactional(readOnly = true)
	public Page<Canton> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return cantdao.findAll(pageable);
	}

	@Override
	public void deleteCanton(Long id) {
		// TODO Auto-generated method stub
		cantdao.deleteById(id);
	}







}
