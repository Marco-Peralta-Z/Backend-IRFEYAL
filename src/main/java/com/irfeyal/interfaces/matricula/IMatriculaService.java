package com.irfeyal.interfaces.matricula;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.matricula.Matricula;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;

public interface IMatriculaService {
public List<Matricula> findAll();
	
	public Page<Matricula> findAll(Pageable pageable);
	
	public Matricula findById(Long id);
	
	public Matricula save(Matricula matricula);
	
	public void delete (Long id);
	
	public List<Matricula> findByCedulaEstudiante(String cedula);
	
	public List<Matricula> findHistorialEstudianteMatricula(Long id);
	public List<Matricula> listarMatriculasActivas();
	
	/*
	// MODULO TUTORIAS
    public List<Asignatura> listarIdsAsignaturas(Long id_periodo);
	*/
}
