package com.irfeyal.servicio.rolseguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irfeyal.modelo.dao.rolseguridad.CantonDAO;
import com.irfeyal.modelo.rolseguridad.Canton;


@Service
public class CantonService implements CantonInterface {

	
	@Autowired
	private CantonDAO cantondao;

	
	@Override
	public List<Canton> findAll() {
		// TODO Auto-generated method stub
		return (List<Canton>) cantondao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Canton> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return cantondao.findAll(pageable);
	}

	@Override
	public Canton findById(Long id) {
		// TODO Auto-generated method stub
		return cantondao.findById(id).orElse(null);
	}

	@Override
	public Canton saveCanton(Canton canton) {
		// TODO Auto-generated method stub
		return cantondao.save(canton);
	}

	@Override
	public void deleteCanton(Long id) {
		// TODO Auto-generated method stub
		cantondao.deleteById(id);
	}

	




}
