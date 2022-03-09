package com.example.demo.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.IEstudianteDao;
import com.example.demo.models.dao.IPersonaDao;
import com.example.demo.models.entity.Estudiante;
import com.example.demo.models.entity.Persona;



@Service
public class EstudianteServiceImpl implements IEstudianteService{

	
	@Autowired
	private IEstudianteDao estudianteDao;
	
	@Autowired IPersonaDao personaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Estudiante> findAll() {
		return (List<Estudiante>) estudianteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Estudiante> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return estudianteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Estudiante findById(Long id) {
		// TODO Auto-generated method stub
		return estudianteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Estudiante save(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return estudianteDao.save(estudiante);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		estudianteDao.deleteById(id);
	}

	@Override
	@Transactional
	public Persona savePersona(Persona persona) {
		// TODO Auto-generated method stub
		return personaDao.save(persona);
	}
	
	
	
	
	
}
