package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.interfaz.ProvinciaInterface;
import com.example.demo.models.dao.ProvinciaDAO;
import com.example.demo.models.entity.Provincia;
@Service
public class ProvinciaServices implements ProvinciaInterface {
	@Autowired
	  private ProvinciaDAO provdao;

	@Override
	public List<Provincia> findAll() {
		// TODO Auto-generated method stub
		return (List<Provincia>) provdao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Provincia> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return provdao.findAll(pageable);
	}

	@Override
	public Provincia findById(Long id) {
		// TODO Auto-generated method stub
		return provdao.findById(id).orElse(null);
	}

	@Override
	public Provincia saveProvincia(Provincia provincia) {
		// TODO Auto-generated method stub
		return provdao.save(provincia);
	}

	@Override
	public void deleteProvincia(Long id) {
		// TODO Auto-generated method stub
		provdao.deleteById(id);
	}



	

	  
	  
	  
}