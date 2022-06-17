package com.irfeyal.modelo.dao.parametrizacionacademica;

import com.irfeyal.modelo.parametrizacionacademica.Curso;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	
	/*MODULO ASISTENCIA*/

	@Query(value="SELECT c.id_curso,c.descripcion,c.fecha_creacion "
			+ "FROM periodo p join  malla m on p.id_malla = m.id_malla  "
			+ "	join malla_asignatura ma on ma.id_malla = m.id_malla "
			+ "	join asignatura asig on asig.id_asignatura = ma.id_asignatura "
			+ "	join asignatura_empleado asigemple on asigemple.id_asignatura = asig.id_asignatura "
			+ "	join modalidad mo on m.id_modalidad=mo.id_modalidad "
			+ "	join malla_curso mc on m.id_malla=mc.id_malla "
			+ "	join curso c on mc.id_curso=c.id_curso "
			+ "		where asigemple.id_empleado=?1 and p.id_periodo=?2 and mo.id_modalidad=?3",nativeQuery=true)
	List<Curso> listarcursoasistencia(Long empelado ,Long periodo, Long idmoda);
	
	/*MODULO TUTORIAS*/
	
	@Query(value = " SELECT c.id_curso,c.descripcion,c.fecha_creacion "
			+ "	FROM periodo p join  malla m on p.id_malla = m.id_malla  "
			+ "	join malla_asignatura ma on ma.id_malla = m.id_malla "
			+ "	join asignatura asig on asig.id_asignatura = ma.id_asignatura "
			+ "	join asignatura_empleado asigemple on asigemple.id_asignatura = asig.id_asignatura "
			+ "	join modalidad mo on m.id_modalidad=mo.id_modalidad "
			+ "	join malla_curso mc on m.id_malla=mc.id_malla "
			+ "	join curso c on mc.id_curso=c.id_curso "
			+ "	where asigemple.id_empleado=?1 and p.id_periodo=?2 and mo.id_modalidad=?3", nativeQuery = true)
	List<Curso> ListCursosempelados(Long empleado, Long id_modalidad, Long id_periodo);
	
	
}
