package com.irfeyal.modelo.dao.secretaria;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.secretaria.GenerarCertificadoMatricula;

public interface IGenerarCertificadoMatriculaDao extends CrudRepository<GenerarCertificadoMatricula, Long>{

	Page<GenerarCertificadoMatricula> findAll(Pageable pageable);
	
	@Query(value="select g from GenerarCertificadoMatricula g where g.matricula.estudiante.id_persona.cedula like %?1%")
	public List<GenerarCertificadoMatricula> findByCedulaEstudiante(String cedula);
	
}
