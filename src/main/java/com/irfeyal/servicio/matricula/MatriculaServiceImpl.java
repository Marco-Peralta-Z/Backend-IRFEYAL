package com.irfeyal.servicio.matricula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irfeyal.interfaces.matricula.IMatriculaService;
import com.irfeyal.modelo.dao.matricula.IMatriculaDao;
import com.irfeyal.modelo.dao.parametrizacionacademica.AsignaturaRepository;
import com.irfeyal.modelo.matricula.Matricula;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;

@Service
public class MatriculaServiceImpl implements IMatriculaService{
	
	@Autowired
	private IMatriculaDao matriculaDao;
	
	@Autowired
	private AsignaturaRepository asignaturaRepo;
	
	@Override
	@Transactional(readOnly = true)
	public List<Matricula> findAll() {
		// TODO Auto-generated method stub
		return (List<Matricula>) matriculaDao.findAll();
	}

	@Override
	public Page<Matricula> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return matriculaDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Matricula findById(Long id) {
		// TODO Auto-generated method stub
		return matriculaDao.findById(id).orElse(null);
	}

	@Override
	public Matricula save(Matricula matricula) {
		// TODO Auto-generated method stub
		return matriculaDao.save(matricula);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		matriculaDao.deleteById(id);
	}

	@Override
	public List<Matricula> findByCedulaEstudiante(String cedula) {
		// TODO Auto-generated method stub
		return matriculaDao.findByCedulaEstudiante(cedula);
	}

	@Override
	public List<Matricula> findHistorialEstudianteMatricula(Long id) {
		// TODO Auto-generated method stub
		return matriculaDao.findHistorialEstudianteMatricula(id);
	}
	
	/*
	// MODULO TUTORIAS 
		@Override
		public List<Asignatura> listarIdsAsignaturas(Long id_periodo) {
			return asignaturaRepo.ids_asignatura(id_periodo);
		}
	*/

}
