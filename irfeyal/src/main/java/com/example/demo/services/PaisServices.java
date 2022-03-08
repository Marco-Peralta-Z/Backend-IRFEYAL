package com.example.demo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.PaisDAO;
import com.example.demo.models.entity.Pais;
@Service
public class PaisServices implements PaisServicesI {
	
 
	
	@Autowired
  private PaisDAO paisdao;
  
  
  
  
	@Override
	@Transactional(readOnly = true)
	public List<Pais> findAll() {
		// TODO Auto-generated method stub
		return (List<Pais> ) paisdao.findAll();
	}

	@Override
	public List<Pais> savePais() {
		// TODO Auto-generated method stub
		return (List<Pais> ) paisdao.findAll();
	}
	@Override
	public List<Pais> deletePais() {
		// TODO Auto-generated method stub
		return (List<Pais> ) paisdao.findAll();
	}
	@Override
	public List<Pais> updatePais() {
		// TODO Auto-generated method stub
		return (List<Pais> ) paisdao.findAll();
	}
	
	

}
