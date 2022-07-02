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
			+ "where asigemple.id_empleado=?1 and p.id_periodo=?2 and mo.id_modalidad=?3 and c.id_curso=?4 and pa.id_paralelo=?5"
			+ " group by asig.id_asignatura",nativeQuery=true)
	List<Asignatura> listarasignaturaasistencia(Long empelado , Long idperiodo,Long idmod, Long idcurso,Long idparalelo);
	
	
	/*MODULO TUTORIAS*/
	
	@Query(value = "select a.id_asignatura, a.descripcion, a.fecha_creacion from asignatura a "
			+ " inner join malla_asignatura ma on ma.id_asignatura = a.id_asignatura "
			+ " inner join malla_curso mc on mc.id_malla = ma.id_malla "
			+ " inner join malla m on m.id_malla = mc.id_malla "
			+ " inner join periodo p on p.id_malla = m.id_malla "
			+ " inner join modalidad m2 on m2.id_modalidad = m.id_modalidad "
			+ " inner join asignatura_empleado ae on ae.id_asignatura = a.id_asignatura "
			+ " inner join tutor t on t.id_curso = mc.id_curso "
			+ " inner join paralelo p2 on p2.id_paralelo = t.id_paralelo "
			+ " where ae.id_empleado=?1 and p.id_periodo =?2 and m.id_malla =?3 and m2.id_modalidad =?4 and mc.id_curso=?5 and p2.id_paralelo=?6 "
			+ " group by a.id_asignatura "
			+ " order by a.id_asignatura ", nativeQuery = true)
	List<Asignatura> ListAsignaturaempleados(Long empleado, Long id_periodo, Long id_malla, Long id_modalidad, Long id_curso, Long id_paralelo);
	
	
	
	@Query(value="select a.id_asignatura, a.descripcion, a.fecha_creacion from malla m "
			+ "inner join periodo p on p.id_malla = m.id_malla "
			+ "inner join malla_asignatura ma on ma.id_malla = p.id_malla "
			+ "inner join asignatura a on a.id_asignatura = ma.id_asignatura "
			+ "where p.id_periodo = ?1 ",nativeQuery=true)
	List<Asignatura> ids_asignatura(Long id_periodo);
	
	
	/*FIN MODULO TUTORIAS */
	
	
}
