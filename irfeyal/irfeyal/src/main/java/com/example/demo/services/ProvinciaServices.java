package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.ProvinciaDAO;
import com.example.demo.models.entity.Provincia;
@Service
public class ProvinciaServices implements ProvinciaServicesI {
	@Autowired
	  private ProvinciaDAO provdao;

	@Override
	public List<Provincia> findAll() {
		// TODO Auto-generated method stub
		return (List<Provincia>) provdao.findAll();
	}

	@Override
	public List<Provincia> saveProv() {
		// TODO Auto-generated method stub
		return (List<Provincia>) provdao.findAll();
	}

	@Override
	public List<Provincia> deleteProv() {
		// TODO Auto-generated method stub
		return (List<Provincia>) provdao.findAll();
	}

	@Override
	public List<Provincia> updateProv() {
		// TODO Auto-generated method stub
		return (List<Provincia>) provdao.findAll();
	}

	

	  
	  
	  
}