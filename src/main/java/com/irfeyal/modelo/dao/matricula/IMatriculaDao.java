package com.irfeyal.modelo.dao.matricula; 

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.irfeyal.modelo.matricula.Matricula;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;

public interface IMatriculaDao extends CrudRepository<Matricula, Long>{

	
	Page<Matricula> findAll(Pageable pageable);

	/*MODULO TUTORIAS*/
	
	@Query(value="SELECT re.id_registro ,m.id_matricula, m.id_curso, m.id_estudiante, m.id_modalidad, m.id_paralelo, m.id_periodo, m.id_usuario, m.modalidad, m.fecha_matricula, per.cedula, per.nombre, per.apellido, re.aporte1, re.aporte2, re.aporte3, re.aporte4, re.aporte5, re.aporte6, re.aporte7, re.aporte8, re.comportamiento, re.evaluacion1, re.evaluacion2, re.examen_gracia, re.examen_remedial, re.examen_supletorio, re.examenfinal, re.id_asignatura, re.id_matricula, re.promedio_gracia, re.promedio_remedial, re.promedio_supletorio, re.promediofinal"
			+ " FROM matriculas m "
			+ " inner join registro re on re.id_matricula = m.id_matricula "
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
	
	@Query(value="select m from Matricula m where m.estudiante.id_persona.cedula like %?1%")
	public List<Matricula> findByCedulaEstudiante(String cedula);
	
}
