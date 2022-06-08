package com.irfeyal.interfaces.matricula;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.irfeyal.modelo.matricula.Matricula;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;

public interface IMatriculaService {
public List<Matricula> findAll();
	
	public Page<Matricula> findAll(Pageable pageable);
	
	public Matricula findById(Long id);
	
	public Matricula save(Matricula matricula);
	
	public void delete (Long id);
	
	public List<Matricula> findByCedulaEstudiante(String cedula);
	
}
