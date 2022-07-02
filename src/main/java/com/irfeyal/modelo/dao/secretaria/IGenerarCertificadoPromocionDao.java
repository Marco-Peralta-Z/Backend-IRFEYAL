package com.irfeyal.modelo.dao.secretaria;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.secretaria.GenerarCertificadoPromocion;

public interface IGenerarCertificadoPromocionDao extends CrudRepository<GenerarCertificadoPromocion, Long>{
	
	Page<GenerarCertificadoPromocion> findAll(Pageable pageable);
	
	@Query(value="select gp from GenerarCertificadoPromocion gp where gp.registro.id_matricula.estudiante.id_persona.cedula like %?1%")
	public List<GenerarCertificadoPromocion> findByCedulaEstudiante(String cedula);
	
}
