package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.dao.PersonaDAO;
import com.example.demo.models.entity.Persona;
@Service
public class PersonaServices implements PersonaServicesI{

	@Autowired
  private PersonaDAO personadao;

	@Override
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		return (List<Persona> ) personadao.findAll();
	}

	@Override
	public List<Persona> savePersona() {
		// TODO Auto-generated method stub
		return (List<Persona> ) personadao.findAll();
	}

	@Override
	public List<Persona> deletePersona() {
		// TODO Auto-generated method stub
		return (List<Persona> ) personadao.findAll();
	}

	@Override
	public List<Persona> updatePersona() {
		// TODO Auto-generated method stub
		return (List<Persona> ) personadao.findAll();
	}
  
  
  
  
	
}
