package com.irfeyal.modelo.dao.asistencia;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.asistencia.Asistencia;

public interface IAsistenciaDao extends JpaRepository<Asistencia, Long>{
	
	
	@Query(value="SELECT * "
			+ "FROM Asistencia asis "
			+ "join clase c on c.id_clase=asis.id_clase "
			+ "WHERE  c.id_modalidad_id_modalidad=?1 and c.id_periodo_id_periodo=?2 and c.id_paralelo=?3 and c.id_asignatura=?4 and c.id_curso=?5 and c.fec_clase=?6",nativeQuery=true)
	Asistencia buscarasistencia(Long id_mod, Long id_periodo, Long id_paralelo, Long id_asignatura,Long id_curso,Date fecha);
}
