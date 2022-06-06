package com.irfeyal.servicio.matricula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irfeyal.interfaces.matricula.IEstudianteService;
import com.irfeyal.modelo.dao.matricula.IEstudianteDao;
import com.irfeyal.modelo.matricula.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {
	
	@Autowired
	private IEstudianteDao estudianteDao;

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
	@Transactional(readOnly = true)
	public Estudiante findByCedula(String cedula) {
		// TODO Auto-generated method stub
		return estudianteDao.findByCedula(cedula);
	}
	
	@Transactional(readOnly = true)
	public List<Estudiante> findAllByCedula(String cedula) {
		// TODO Auto-generated method stub
		return estudianteDao.findAllByCedula(cedula);
	}
}
