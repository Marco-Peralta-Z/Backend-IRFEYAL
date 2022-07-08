package com.irfeyal.modelo.dao.inventarios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irfeyal.modelo.inventarios.Kit;



@Repository//("kitRepo")
public interface KitDao extends CrudRepository<Kit, Long> {

	
	@Query(nativeQuery = true, value = "select ki.precio_kit from  matriculas ma \n"
			+ "inner join kit ki on ki.id_curso = ma.id_curso\n"
			+ "where  ma.id_estudiante = :id_estudiante")
	public Integer kitEstudianteParaPagos(Long id_estudiante);
}
