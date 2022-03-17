package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.DireccionDAO;

import com.example.demo.models.entity.Direccion;
@Service
public class DireccionServices implements DireccionServicesI {

	@Autowired
  private DireccionDAO direcciondao;
  
  
  
	@Override
	public List<Direccion> findAll() {
		// TODO Auto-generated method stub
		return (List<Direccion> ) direcciondao.findAll();
	}

	@Override
	public List<Direccion> saveDireccion() {
		// TODO Auto-generated method stub
		return (List<Direccion> ) direcciondao.findAll();
	}

	@Override
	public List<Direccion> deleteDireccion() {
		// TODO Auto-generated method stub
		return (List<Direccion> ) direcciondao.findAll();
	}

	@Override
	public List<Direccion> updateDireccion() {
		// TODO Auto-generated method stub
		return (List<Direccion> ) direcciondao.findAll();
	}

}
