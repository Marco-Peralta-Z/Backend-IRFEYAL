package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.interfaz.PersonaInterface;
import com.example.demo.models.dao.PersonaDAO;
import com.example.demo.models.entity.Persona;
@Service
public class PersonaServices implements PersonaInterface{

	@Autowired
  private PersonaDAO personadao;

	@Override
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		return (List<Persona>) personadao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Persona> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return personadao.findAll(pageable);
	}

	@Override
	public Persona findById(Long id) {
		// TODO Auto-generated method stub
		return personadao.findById(id).orElse(null);
	}

	@Override
	public Persona savePersona(Persona persona) {
		// TODO Auto-generated method stub
		return personadao.save(persona);
	}

	@Override
	public void deletePersona(Long id) {
		// TODO Auto-generated method stub
		personadao.deleteById(id);
	}


  
  
  
	
}
