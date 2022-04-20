package com.irfeyal.modelo.dao.rolseguridad;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.rolseguridad.Persona;



public interface PersonaDAO extends CrudRepository<Persona, Long> {
	Page<Persona> findAll(Pageable pageable);
	
	
	//------------------------Modulo Asistencia--------------------------
	
	@Query(value="SELECT * FROM Persona p INNER JOIN Estudiantes e on p."
	  		+ "id_persona=e.id_persona INNER JOIN matriculas m "
	  		+ "ON e.id_estudiante=m.id_estudiante  WHERE m.id_curso = ? ",nativeQuery = true)
	List <Persona> buscarcurso(Long id);
	
	//---------------------Fin Modulo Asistencia--------------------------
}
