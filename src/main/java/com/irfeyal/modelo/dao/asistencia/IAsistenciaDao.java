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
			+ "WHERE asis.id_estudiante = ?1",nativeQuery=true)
	List<Asistencia> obtenerIdEstudiante(Long id_estudiante);
}
