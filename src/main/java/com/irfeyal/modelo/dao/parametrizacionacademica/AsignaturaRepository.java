package com.irfeyal.modelo.dao.parametrizacionacademica;

import java.util.List;

import com.irfeyal.modelo.parametrizacionacademica.Asignatura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
	
	
	/*MODULO ASISTENCIA*/
	@Query(value="SELECT asig.id_asignatura, asig.descripcion,asig.fecha_creacion  "
			+ "FROM periodo p join  malla m on p.id_malla = m.id_malla  "
			+ "join malla_asignatura ma on ma.id_malla = m.id_malla "
			+ "join asignatura asig on asig.id_asignatura = ma.id_asignatura "
			+ "join asignatura_empleado asigemple on asigemple.id_asignatura = asig.id_asignatura "
			+ "join modalidad mo on m.id_modalidad=mo.id_modalidad "
			+ "join malla_curso mc on m.id_malla=mc.id_malla "
			+ "join curso c on mc.id_curso=c.id_curso "
			+ "join tutor t on c.id_curso=t.id_curso "
			+ "join paralelo pa on t.id_paralelo=pa.id_paralelo "
			+ "where asigemple.id_empleado=?1 and p.id_periodo=?2 and mo.id_modalidad=?3 and c.id_curso=?4 and pa.id_paralelo=?5",nativeQuery=true)
	List<Asignatura> listarasignaturaasistencia(Long empelado , Long idperiodo,Long idmod, Long idcurso,Long idparalelo);
	
	
	/*MODULO TUTORIAS*/
	
	@Query(value = "SELECT asig.id_asignatura, asig.descripcion,asig.fecha_creacion  "
			+ "	FROM periodo p join  malla m on p.id_malla = m.id_malla  "
			+ "	join malla_asignatura ma on ma.id_malla = m.id_malla "
			+ "	join asignatura asig on asig.id_asignatura = ma.id_asignatura "
			+ "	join asignatura_empleado asigemple on asigemple.id_asignatura = asig.id_asignatura "
			+ "	join modalidad mo on m.id_modalidad=mo.id_modalidad "
			+ "	join malla_curso mc on m.id_malla=mc.id_malla "
			+ "	join curso c on mc.id_curso=c.id_curso "
			+ "	join tutor t on c.id_curso=t.id_curso "
			+ "	join paralelo pa on t.id_paralelo=pa.id_paralelo "
			+ "	where asigemple.id_empleado=?1 and p.id_periodo=?2 and mo.id_modalidad=?3 and c.id_curso=?4 and pa.id_paralelo=?5", nativeQuery = true)
	List<Asignatura> ListAsignaturaempleados(Long empleado, Long id_periodo, Long id_curso, Long id_paralelo, Long id_modalidad);
	
	
}
