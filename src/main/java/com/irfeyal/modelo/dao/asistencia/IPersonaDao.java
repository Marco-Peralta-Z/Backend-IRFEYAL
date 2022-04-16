package com.irfeyal.modelo.dao.asistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.irfeyal.modelo.rolseguridad.Persona;

public interface IPersonaDao extends JpaRepository<Persona, Long> {
	
	 @Query(value="SELECT * FROM Persona p INNER JOIN Estudiantes e on p."
		  		+ "id_persona=e.id_persona INNER JOIN matriculas m "
		  		+ "ON e.id_estudiante=m.id_estudiante  WHERE m.id_curso = ? ",nativeQuery = true)
		List <Persona> buscarcurso(Long id);

}
