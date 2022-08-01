package com.irfeyal.modelo.dao.asistencia;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.irfeyal.modelo.asistencia.Clase;



public interface IClaseDao extends JpaRepository<Clase, Long>{
	
	@Query(value="SELECT * FROM clase c JOIN asistencia a ON a.id_clase=c.id_clase "
			+ "			JOIN estudiantes e  on e.id_estudiante = a.id_estudiante "
			+ "			WHERE e.id_estudiante=?1 and c.id_docente=?2  and c.id_asignatura=?3 and c.id_curso=?4 and c.id_paralelo=?5 and c.id_modalidad_id_modalidad=?6 and c.id_periodo_id_periodo=?7 and a.estado_asis=true",nativeQuery=true)
	List<Clase> mostrarfechasid(Long idestudiante, Integer iddocente, Integer idasignatura, Integer idcurso,
			Integer idparalelo, Integer idmodalidad, Integer idperiodo);


	@Query(value="SELECT * FROM clase ORDER BY id_clase DESC LIMIT 1"  ,nativeQuery=true)
	 Clase findclaseingreseda();
	
	@Query(value="SELECT * FROM clase c "
			+ "	where c.id_docente=?1 and c.id_periodo_id_periodo=?2 and c.id_modalidad_id_modalidad=?3 and c.id_curso=?4 and c.id_paralelo=?5 and c.id_asignatura=?6 and c.fec_clase=?7",nativeQuery=true)
	List<Clase> validarclase(Integer iddocente,Integer idperiodo,Integer idmodalidad,Integer idcurso,
			Integer idparalelo,Integer idasignatura,Date fecha);
	
	@Query(value="SELECT count(c)  FROM clase c "
			+ "	where c.id_docente=?1 and c.id_periodo_id_periodo=?2 and c.id_modalidad_id_modalidad=?3 and c.id_curso=?4 and c.id_paralelo=?5 and c.id_asignatura=?6 and c.fec_clase=?7",nativeQuery=true)
	Long validarclass(Integer iddocente,Integer idperiodo,Integer idmodalidad,Integer idcurso,
			Integer idparalelo,Integer idasignatura,Date fecha);
	
	@Query(value="SELECT * FROM clase c JOIN asistencia a ON a.id_clase=c.id_clase "
			+ "			JOIN estudiantes e  on e.id_estudiante = a.id_estudiante "
			+ "			WHERE e.id_estudiante=?1 and c.id_docente=?2 and c.id_asignatura=?3 and a.estado_asis=true and c.fec_clase>=?4 and c.fec_clase<=?5",nativeQuery=true)
	  Iterable<Clase> mostrarfechasidpdf(Long idestudiante,Long iddocente, Long idasignatura, Date fechainicio,Date fechafin);
	
	@Query(value="SELECT * FROM clase c JOIN asistencia a ON a.id_clase=c.id_clase "
			+ "			JOIN estudiantes e  on e.id_estudiante = a.id_estudiante "
			+ "			WHERE e.id_estudiante=?1  and c.id_asignatura=?2 and a.estado_asis=true and c.fec_clase>=?3 and c.fec_clase<=?4",nativeQuery=true)
	  Iterable<Clase> mostrarfechasidpdfadmin(Long idestudiante, Long idasignatura, Date fechainicio,Date fechafin);
}
