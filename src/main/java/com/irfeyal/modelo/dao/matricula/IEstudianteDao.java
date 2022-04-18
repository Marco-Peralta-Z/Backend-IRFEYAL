package com.irfeyal.modelo.dao.matricula;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.matricula.Estudiante;

public interface IEstudianteDao  extends CrudRepository<Estudiante, Long> {
	
	
	Page<Estudiante> findAll(Pageable pageable);
	
	
	//-----------------------Modulo Asistencia--------------------
	
	@Query(value="SELECT * FROM Estudiantes e INNER JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "inner JOIN asistencia a on a.id_estudiante=e.id_estudiante "
			+ "INNER JOIN clase c on a.id_clase= c.id_clase  "
			+ "WHERE c.id_modalidad_id_modalidad =?1 "
			+ "GROUP BY e.id_estudiante",nativeQuery=true)
	List<Estudiante> buscarcursomodalidad(Long id_mod);
	@Query(value="SELECT * FROM Estudiantes e INNER JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "inner JOIN asistencia a on a.id_estudiante=e.id_estudiante "
			+ "INNER JOIN clase c on a.id_clase= c.id_clase  "
			+ "WHERE c.id_periodo_id_periodo=?1 "
			+ "GROUP BY e.id_estudiante",nativeQuery=true)
	List<Estudiante> buscarcursoperiodo(Long id_periodo);
	@Query(value="SELECT * FROM Estudiantes e INNER JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "inner JOIN asistencia a on a.id_estudiante=e.id_estudiante "
			+ "INNER JOIN clase c on a.id_clase= c.id_clase  "
			+ "WHERE m.id_paralelo=?1 "
			+ "GROUP BY e.id_estudiante",nativeQuery=true)
	List<Estudiante> buscarcursoparalelo(Long id_paralelo);
	@Query(value="SELECT * FROM Estudiantes e INNER JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "inner JOIN asistencia a on a.id_estudiante=e.id_estudiante "
			+ "INNER JOIN clase c on a.id_clase= c.id_clase  "
			+ "WHERE c.id_asignatura=?1 "
			+ "GROUP BY e.id_estudiante",nativeQuery=true)
	List<Estudiante> buscarcursoasignatura(Long id_asignatura);
	
	
	@Query(value="SELECT * FROM Estudiantes e INNER JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "inner JOIN asistencia a on a.id_estudiante=e.id_estudiante "
			+ "INNER JOIN clase c on a.id_clase= c.id_clase  "
			+ "WHERE c.id_modalidad_id_modalidad =?1 AND c.id_periodo_id_periodo=?2 "
			+ "GROUP BY e.id_estudiante",nativeQuery=true)
	List<Estudiante> buscarcursomodperi(Long id_mod, Long id_periodo);
	@Query(value="SELECT * FROM Estudiantes e INNER JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "inner JOIN asistencia a on a.id_estudiante=e.id_estudiante "
			+ "INNER JOIN clase c on a.id_clase= c.id_clase  "
			+ "WHERE c.id_modalidad_id_modalidad =?1 AND m.id_paralelo=?2 "
			+ "GROUP BY e.id_estudiante",nativeQuery=true)
	List<Estudiante> buscarcursomodpar(Long id_mod, Long id_paralelo);
	@Query(value="SELECT * FROM Estudiantes e INNER JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "inner JOIN asistencia a on a.id_estudiante=e.id_estudiante "
			+ "INNER JOIN clase c on a.id_clase= c.id_clase  "
			+ "WHERE c.id_modalidad_id_modalidad =?1 AND c.id_asignatura=?2 "
			+ "GROUP BY e.id_estudiante",nativeQuery=true)
	List<Estudiante> buscarcursomodasig(Long id_mod, Long id_asignatura);
	@Query(value="SELECT * FROM Estudiantes e INNER JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "inner JOIN asistencia a on a.id_estudiante=e.id_estudiante "
			+ "INNER JOIN clase c on a.id_clase= c.id_clase  "
			+ "WHERE c.id_periodo_id_periodo=?1 AND m.id_paralelo=?2 "
			+ "GROUP BY e.id_estudiante",nativeQuery=true)
	List<Estudiante> buscarcursoperipar(Long id_periodo, Long id_paralelo);
	@Query(value="SELECT * FROM Estudiantes e INNER JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "inner JOIN asistencia a on a.id_estudiante=e.id_estudiante "
			+ "INNER JOIN clase c on a.id_clase= c.id_clase  "
			+ "WHERE c.id_periodo_id_periodo=?1 AND c.id_asignatura=?2 "
			+ "GROUP BY e.id_estudiante",nativeQuery=true)
	List<Estudiante> buscarcursoperiasig(Long id_periodo, Long id_asignatura);
	@Query(value="SELECT * FROM Estudiantes e INNER JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "inner JOIN asistencia a on a.id_estudiante=e.id_estudiante "
			+ "INNER JOIN clase c on a.id_clase= c.id_clase  "
			+ "WHERE m.id_paralelo=?1 AND c.id_asignatura=?2 "
			+ "GROUP BY e.id_estudiante",nativeQuery=true)
	List<Estudiante> buscarcursoparasig(Long id_paralelo, Long id_asignatura);
	
	
	
	@Query(value="SELECT * FROM Estudiantes e INNER JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "inner JOIN asistencia a on a.id_estudiante=e.id_estudiante "
			+ "INNER JOIN clase c on a.id_clase= c.id_clase "
			+ "WHERE  c.id_modalidad_id_modalidad =?1 AND c.id_periodo_id_periodo=?2 AND m.id_paralelo=?3  "
			+ "GROUP BY e.id_estudiante",nativeQuery=true)
	List<Estudiante> buscarcursomodperpar(Long id_mod, Long id_periodo, Long id_paralelo);
	@Query(value="SELECT * FROM Estudiantes e INNER JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "inner JOIN asistencia a on a.id_estudiante=e.id_estudiante "
			+ "INNER JOIN clase c on a.id_clase= c.id_clase "
			+ "WHERE  c.id_periodo_id_periodo=?1 AND m.id_paralelo=?2 AND c.id_asignatura=?3  "
			+ "GROUP BY e.id_estudiante",nativeQuery=true)
	List<Estudiante> buscarcursoperparasig(Long id_periodo, Long id_paralelo, Long id_asignatura);
	@Query(value="SELECT * FROM Estudiantes e INNER JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "inner JOIN asistencia a on a.id_estudiante=e.id_estudiante "
			+ "INNER JOIN clase c on a.id_clase= c.id_clase "
			+ "WHERE c.id_modalidad_id_modalidad =?1 AND m.id_paralelo=?2 AND c.id_asignatura=?3  "
			+ "GROUP BY e.id_estudiante",nativeQuery=true)
	List<Estudiante> buscarcursomodparasig(Long id_mod, Long id_paralelo, Long id_asignatura);
	@Query(value="SELECT * FROM Estudiantes e INNER JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "inner JOIN asistencia a on a.id_estudiante=e.id_estudiante "
			+ "INNER JOIN clase c on a.id_clase= c.id_clase "
			+ "WHERE c.id_modalidad_id_modalidad =?1 AND  c.id_periodo_id_periodo=?2 AND c.id_asignatura=?3  "
			+ "GROUP BY e.id_estudiante",nativeQuery=true)
	List<Estudiante> buscarcursomodpersig(Long id_mod, Long id_periodo, Long id_asignatura);
	
	
	
	@Query(value="SELECT * FROM Estudiantes e INNER JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "inner JOIN asistencia a on a.id_estudiante=e.id_estudiante "
			+ "INNER JOIN clase c on a.id_clase= c.id_clase "
			+ "WHERE  c.id_modalidad_id_modalidad =?1 AND c.id_periodo_id_periodo=?2 AND m.id_paralelo=?3 AND c.id_asignatura=?4 "
			+ "GROUP BY e.id_estudiante",nativeQuery=true)
	List<Estudiante> buscarcursomodalidad(Long id_mod, Long id_periodo, Long id_paralelo, Long id_asignatura);
	
	@Query(value="SELECT * FROM Estudiantes e INNER JOIN Persona p ON e."+"id_persona =p.id_persona WHERE p.cedula =?1",nativeQuery=true)
	Estudiante buscarcedulaestudiante(String cedula);
	
	@Query(value="SELECT * FROM clase c JOIN asistencia a ON a.id_clase=c.id_clase "
			+ "JOIN estudiantes e  on e.id_estudiante = a.id_estudiante "
			+ "WHERE c.id_docente_id_rolusuario=?1"
			+ "GROUP BY e.id_estudiante",nativeQuery=true)
	List<Estudiante> cargarest( Integer iddocente);
	
	//-----------------------------Fin Modulo Asistencia-----------------------

}
