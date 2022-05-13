package com.irfeyal.modelo.dao.parametrizacionacademica;

import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	
	/*MODULO ASISTENCIA*/

	@Query(value="SELECT c.id_curso,c.descripcion,c.tipo_curso,c.fecha_creacion, c.id_empleado   "
			+ "FROM curso c "
			+ "join  modalidad_curso mc on mc.id_curso = c.id_curso "
			+ "join modalidad m on m.id_modalidad = mc.id_modalidad "
			+ "where c.id_empleado=?1 and mc.id_modalidad=?2 group by c.id_curso",nativeQuery=true)
	List<Curso> listarcursoasistencia(Long empelado , Long idmoda);
	
	/*MODULO TUTORIAS*/
	
	@Query(value = " SELECT c.id_curso,c.descripcion, c.tipo_curso, c.fecha_creacion, c.id_empleado " 
	        + "	FROM curso c "
			+ "	inner join modalidad_curso mcur on mcur.id_curso = c.id_curso "
			+ "	inner join modalidad m on m.id_modalidad = mcur.id_modalidad "
			+ " inner join malla_curso mc on mc.id_curso = c.id_curso"
			+ " inner join malla ma on ma.id_malla = mc.id_malla"
			+ " inner join periodo pe on pe.id_malla = ma.id_malla"
			+ " where c.id_empleado=?1 and m.id_modalidad=?2 and pe.id_periodo=?3 group by c.id_curso", nativeQuery = true)
	List<Curso> ListCursosempelados(Long empleado, Long id_modalidad, Long id_periodo);
	
	
}
