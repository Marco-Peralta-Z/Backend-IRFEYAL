package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.RolDAO;
import com.example.demo.models.entity.Rol;

@Service
public class RolServices implements RolServicesI {
	

	@Autowired
  private RolDAO roldao;
  

	@Override
	public List<Rol> findAll() {
		// TODO Auto-generated method stub
		return (List<Rol> ) roldao.findAll();
	}

	@Override
	public List<Rol> saveRol() {
		// TODO Auto-generated method stub
		return (List<Rol> ) roldao.findAll();
	}

	@Override
	public List<Rol> deleteRol() {
		// TODO Auto-generated method stub
		return (List<Rol> ) roldao.findAll();
	}

	@Override
	public List<Rol> updateRol() {
		// TODO Auto-generated method stub
		return (List<Rol> ) roldao.findAll();
	}

}
