package com.irfeyal.modelo.dao.asistencia;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.asistencia.Asistencia;

public interface IAsistenciaDao extends JpaRepository<Asistencia, Long>{

	
	
	@Query(value="SELECT * "
			+ "FROM Asistencia asis "
			+ "join clase cls on cls.id_clase = asis.id_clase "
			+ "WHERE  cls.id_modalidad_id_modalidad=?1 and cls.id_periodo_id_periodo=?2 and cls.id_paralelo=?3 and cls.id_asignatura=?4 and cls.id_curso=?5 and cls.fec_clase=?6",nativeQuery=true)
	List<Asistencia> buscarasistencia(Long id_mod, Long id_periodo, Long id_paralelo, Long id_asignatura,Long id_curso,Date fecha);

	@Query(value="SELECT * FROM asistencia asis join clase cls on cls.id_clase= asis.id_clase where "
			+ "cls.id_modalidad_id_modalidad=?1 and cls.id_periodo_id_periodo=?2 "
			+ "and cls.id_paralelo=?3 and  cls.id_asignatura=?4 and cls.id_curso=?5 and cls.fec_clase=?6 and cls.id_docente=?7",nativeQuery=true)
	List<Asistencia>actualizarfiltros(Long id_mod, Long id_periodo, Long id_paralelo, Long id_asignatura,Long id_curso,Date fecha, Long iddocente);
	

	@Query(value="SELECT * "
			+ "FROM Asistencia asis "
			+ "join clase c on c.id_clase = asis.id_clase "			
			+ "WHERE asis.id_estudiante = ?1 and c.id_asignatura=?3 and c.id_docente=?2 and asis.estado_asis=true and c.fec_clase>=?4 and c.fec_clase<=?5 ",nativeQuery=true)
	List<Asistencia> obtenerIdEstudiante(Long id_estudiante,Long id_docente,Long idasignatura, Date fechainicio,Date fechafin);
	@Query(value="SELECT * "
			+ "FROM Asistencia asis "
			+ "join clase c on c.id_clase = asis.id_clase "			
			+ "WHERE asis.id_estudiante = ?1 and c.id_asignatura=?2 and asis.estado_asis=true and c.fec_clase>=?3 and c.fec_clase<=?4",nativeQuery=true)
	List<Asistencia> obtenerIdEstudianteAdmin(Long id_estudiante,Long idasignatura , Date fechainicio,Date fechafin);

	@Query(value="SELECT * "
			+ "FROM Asistencia asis "
			+ "join clase cls on cls.id_clase = asis.id_clase "
			+ "WHERE  cls.id_modalidad_id_modalidad=?1 and cls.id_periodo_id_periodo=?2 and cls.id_paralelo=?3  and cls.id_curso=?4 and cls.id_docente=?5 and asis.estado_asis=true and cls.fec_clase>=?6 and cls.fec_clase<=?7",nativeQuery=true)
	List<Asistencia> sistenciapdf(Long id_mod, Long id_periodo, Long id_paralelo,Long id_curso,Long docente,Date fechainicio,Date fechafin);

	@Query(value="SELECT * "
			+ "FROM Asistencia asis "
			+ "join clase cls on cls.id_clase = asis.id_clase "
			+ "WHERE  cls.id_modalidad_id_modalidad=?1 and cls.id_periodo_id_periodo=?2 and cls.id_paralelo=?3  and cls.id_curso=?4 and asis.estado_asis=true and cls.fec_clase>=?5 and cls.fec_clase<=?6",nativeQuery=true)
	List<Asistencia> sistenciapdftutor(Long id_mod, Long id_periodo, Long id_paralelo,Long id_curso,Date fechainicio,Date fechafin);

}
