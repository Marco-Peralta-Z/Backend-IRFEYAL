package com.irfeyal.modelo.dao.asistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.irfeyal.modelo.asistencia.Clase;



public interface IClaseDao extends JpaRepository<Clase, Long>{
	
	@Query(value="SELECT * FROM clase c JOIN asistencia a ON a.id_clase=c.id_clase "
			+ "			JOIN estudiantes e  on e.id_estudiante = a.id_estudiante "
			+ "			WHERE e.id_estudiante=?1 and c.id_docente=?2 and a.estado_asis=true",nativeQuery=true)
	List<Clase> mostrarfechasid(Long idestudiante, Integer iddocente);

	
	@Query(value="SELECT * FROM clase ORDER BY id_clase DESC LIMIT 1"  ,nativeQuery=true)
	 Clase findclaseingreseda();
}
