package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.TelefonoDAO;
import com.example.demo.models.entity.Telefono;
@Service
public class TelefonoServices implements TelefonoServicesI {

	@Autowired
	  private TelefonoDAO telfdao;
	
	@Override
	public List<Telefono> findAll() {
		// TODO Auto-generated method stub
		return (List<Telefono>) telfdao.findAll();
	}

	@Override
	public List<Telefono> saveTelefono() {
		// TODO Auto-generated method stub
		return (List<Telefono>) telfdao.findAll();
	}

	@Override
	public List<Telefono> deleteTelefono() {
		// TODO Auto-generated method stub
		return (List<Telefono>) telfdao.findAll();
	}

	@Override
	public List<Telefono> updateTelefono() {
		// TODO Auto-generated method stub
		return (List<Telefono>) telfdao.findAll();
	}

}
