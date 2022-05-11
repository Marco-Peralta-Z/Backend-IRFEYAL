package com.irfeyal.modelo.dao.parametrizacionacademica;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
	
	
	/*MODULO ASISTENCIA*/
	@Query(value="SELECT a.id_asignatura, a.descripcion,a.fecha_creacion  "
			+ "FROM asignatura a  "
			+ "join malla_asignatura malla_a ON malla_a.id_asignatura = a.id_asignatura  "
			+ "join malla ma on ma.id_malla = malla_a.id_malla  "
			+ "join periodo pe on pe.id_malla = ma.id_malla "
			+ "join malla_curso malcur on malcur.id_malla = ma.id_malla "
			+ "join curso  cur on cur.id_curso = malcur.id_curso  "
			+ "join curso_paralelo curp  on curp.id_curso = cur.id_curso  "
			+ "join paralelo p on p.id_paralelo = curp.id_paralelo   "
			+ "where cur.id_empleado=?1 and pe.id_periodo=?2 and cur.id_curso=?3 and p.id_paralelo=?4 group by a.id_asignatura",nativeQuery=true)
	List<Asignatura> listarasignaturaasistencia(Long empelado , Long idperiodo,Long idcurso,Long idparalelo);
	
	
	/*MODULO TUTORIAS*/
	
	@Query(value = "SELECT a.id_asignatura, a.descripcion, a.fecha_creacion" 
	        + "	FROM asignatura a"
			+ "	join malla_asignatura malla_a ON malla_a.id_asignatura = a.id_asignatura"
			+ "	join malla ma on ma.id_malla = malla_a.id_malla"
			+ "	join periodo pe on pe.id_malla = ma.id_malla"
			+ "	join malla_curso malcur on malcur.id_malla = ma.id_malla"
			+ "	join curso  cur on cur.id_curso = malcur.id_curso"
			+ "	join curso_paralelo curp  on curp.id_curso = cur.id_curso"
			+ "	join paralelo pa on pa.id_paralelo = curp.id_paralelo"
			+ "	where cur.id_empleado=?1 and pe.id_periodo=?2 and cur.id_curso=?3 and pa.id_paralelo=?4"
			+ "	group by a.id_asignatura", nativeQuery = true)
	List<Asignatura> ListAsignaturaempleados(Long empleado, Long id_periodo, Long id_curso, Long id_paralelo);
	
	
}
