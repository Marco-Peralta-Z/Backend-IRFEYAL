package com.irfeyal.modelo.dao.tutorias;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.irfeyal.modelo.tutorias.Registro;

public interface IRegistroDao extends JpaRepository<Registro, Long> {

	//Para secretaria, certificado de promocion
		@Query(value="select r from Registro r where r.id_matricula.estudiante.id_persona.cedula like %?1%")
		public List<Registro> findByCedulaEstudiante(String cedula);
	

	
	

}
