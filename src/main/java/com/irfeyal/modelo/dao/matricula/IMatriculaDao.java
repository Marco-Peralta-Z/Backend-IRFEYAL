package com.irfeyal.modelo.dao.matricula; 

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.irfeyal.modelo.matricula.Matricula;

public interface IMatriculaDao extends CrudRepository<Matricula, Long>{

	
	Page<Matricula> findAll(Pageable pageable);
	
	
	/*MODULO TUTORIAS*/
	
	@Query(value="SELECT m.id_matricula, m.id_curso, m.id_estudiante, m.id_modalidad, m.id_paralelo, m.id_periodo, m.id_usuario, m.modalidad, m.fecha_matricula, per.cedula, per.nombre, per.apellido FROM matriculas m "
			+ " INNER JOIN periodo pe on pe.id_periodo = m.id_periodo "
			+ " inner JOIN modalidad mo on mo.id_modalidad = m.id_modalidad "
			+ " INNER JOIN curso cur on cur.id_curso = m.id_curso "
			+ " inner join paralelo pa on pa.id_paralelo = m.id_paralelo "
			+ " inner join malla_curso mc on mc.id_curso = cur.id_curso "
			+ " inner join malla ma on ma.id_malla = mc.id_malla "
			+ " inner join malla_asignatura mas on mas.id_malla = ma.id_malla "
			+ " inner join asignatura a on a.id_asignatura = mas.id_asignatura "
			+ " inner join estudiantes e on e.id_estudiante = m.id_estudiante "
			+ " inner join persona per on per.id_persona = e.id_persona "
			+ " where pe.id_periodo=?1 and mo.id_modalidad=?2 and cur.id_curso=?3 and pa.id_paralelo=?4 and a.id_asignatura=?5 ",nativeQuery=true)
	List<Matricula> filtrocompleto(Long id_periodo, Long id_modalidad, Long id_curso, Long id_paralelo, Long id_asignatura);
	
}
