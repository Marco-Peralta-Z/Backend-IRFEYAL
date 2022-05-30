package com.irfeyal.modelo.dao.parametrizacionacademica;

import java.util.List;

import com.irfeyal.modelo.parametrizacionacademica.Asignatura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
	
	
	/*MODULO ASISTENCIA*/
	@Query(value="SELECT asig.id_asignatura, asig.descripcion,asig.fecha_creacion   FROM periodo p "
			+ "join  malla m on p.id_malla = m.id_malla  "
			+ "join malla_asignatura ma on ma.id_malla = m.id_malla "
			+ "join asignatura asig on asig.id_asignatura = ma.id_asignatura "
			+ "join asignatura_empleado asigemple on asigemple.id_asignatura = asig.id_asignatura "
			+ "join modalidad mo on p.id_modalidad=mo.id_modalidad "
			+ "join malla_curso mc on m.id_malla=mc.id_malla "
			+ "join curso c on mc.id_curso=c.id_curso "
			+ "join paralelo pa on c.id_paralelo=pa.id_paralelo "
			+ "where asigemple.id_empleado=1 and p.id_periodo=1 and mo.id_modalidad=1 and c.id_curso=1 and pa.id_paralelo=1",nativeQuery=true)
	List<Asignatura> listarasignaturaasistencia(Long empelado , Long idperiodo,Long idmod, Long idcurso,Long idparalelo);
	
	
	/*MODULO TUTORIAS*/
	
	@Query(value = "SELECT a.id_asignatura, a.descripcion, a.fecha_creacion"
			+ "	FROM asignatura a"
			+ "	join malla_asignatura malla_a ON malla_a.id_asignatura = a.id_asignatura"
			+ " join malla ma on ma.id_malla = malla_a.id_malla"
			+ "	join periodo pe on pe.id_malla = ma.id_malla"
			+ "	join malla_curso malcur on malcur.id_malla = ma.id_malla"
			+ "	join curso  cur on cur.id_curso = malcur.id_curso"
			+ "	join curso_paralelo curp  on curp.id_curso = cur.id_curso"
			+ "	join paralelo pa on pa.id_paralelo = curp.id_paralelo"
			+ "	join modalidad_curso moc on moc.id_curso = cur.id_curso"
			+ "	join modalidad mo on mo.id_modalidad = moc.id_modalidad"
			+ "	where cur.id_empleado=?1 and pe.id_periodo=?2 and cur.id_curso=?3 and pa.id_paralelo=?4 and mo.id_modalidad=?5"
			+ "	group by a.id_asignatura", nativeQuery = true)
	List<Asignatura> ListAsignaturaempleados(Long empleado, Long id_periodo, Long id_curso, Long id_paralelo, Long id_modalidad);
	
	
}
