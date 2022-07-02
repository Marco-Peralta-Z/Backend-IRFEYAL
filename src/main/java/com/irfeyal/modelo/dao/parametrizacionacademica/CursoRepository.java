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
			+ " where asigemple.id_empleado=?1 and p.id_periodo=?2 and mo.id_modalidad=?3"
			+ " group by c.id_curso",nativeQuery=true)
	List<Curso> listarcursoasistencia(Long empelado ,Long periodo, Long idmoda);
	
	/*MODULO TUTORIAS*/
	
	@Query(value = " select c.id_curso , c.descripcion , c.fecha_creacion  from curso c "
			+ "join malla_curso mc on mc.id_curso = c.id_curso "
			+ "join malla m on m.id_malla = mc.id_malla  "
			+ "join periodo p on p.id_malla = m.id_malla "
			+ "join malla_asignatura ma on ma.id_malla = m.id_malla "
			+ "join asignatura asig on asig.id_asignatura = ma.id_asignatura "
			+ "join asignatura_empleado ae  on ae.id_asignatura = asig.id_asignatura "
			+ "join modalidad mo on m.id_modalidad=mo.id_modalidad "
			+ "where ae.id_empleado =?1 and p.id_periodo =?2 and m.id_malla =?3 and mo.id_modalidad =?4 "
			+ "group by c.id_curso "
			+ "order by c.id_curso", nativeQuery = true)
	List<Curso> ListCursosempelados(Long empleado, Long id_periodo, Long id_malla, Long id_modalidad);
	
	
}
