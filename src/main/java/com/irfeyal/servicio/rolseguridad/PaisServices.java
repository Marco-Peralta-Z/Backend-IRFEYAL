package com.irfeyal.servicio.rolseguridad;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irfeyal.interfaces.rolseguridad.PaisInterface;
import com.irfeyal.modelo.dao.rolseguridad.PaisDAO;
import com.irfeyal.modelo.rolseguridad.Pais;


@Service
public class PaisServices implements PaisInterface {
	
 
	
	@Autowired
  private PaisDAO paisdao;

	@Override
	public List<Pais> findAll() {
		// TODO Auto-generated method stub
		return (List<Pais>) paisdao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Pais> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return paisdao.findAll(pageable);
	}

	@Override
	public Pais findById(Long id) {
		// TODO Auto-generated method stub
		return paisdao.findById(id).orElse(null);
	}

	@Override
	public Pais savePais(Pais pais) {
		// TODO Auto-generated method stub
		return paisdao.save(pais);
	}

	@Override
	public void deletePais(Long id) {
		// TODO Auto-generated method stub
		paisdao.deleteById(id);
	}

	
}
