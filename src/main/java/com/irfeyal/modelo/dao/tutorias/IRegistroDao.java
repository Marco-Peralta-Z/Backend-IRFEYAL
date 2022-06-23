package com.irfeyal.modelo.dao.tutorias;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.irfeyal.modelo.matricula.Matricula;
import com.irfeyal.modelo.tutorias.Registro;

public interface IRegistroDao extends JpaRepository<Registro, Long> {

	//Para secretaria, certificado de promocion
		@Query(value="select r from Registro r where r.id_matricula.estudiante.id_persona.cedula like %?1%")
		public List<Registro> findByCedulaEstudiante(String cedula);
	

		@Query(value="SELECT p.cedula,p.nombre,p.apellido,re.id_registro, re.aporte1, re.aporte2, re.aporte3, re.aporte4, re.aporte5, re.aporte6, re.aporte7, re.aporte8, re.comportamiento, re.evaluacion1, re.evaluacion2, re.examen_gracia, re.examen_remedial, re.examen_supletorio, re.examenfinal, re.promedio_gracia, re.promedio_remedial, re.promedio_supletorio, re.promediofinal, re.fkid_asignatura, re.id_matricula "
				+ " FROM registro re "
				+ " inner join matriculas m  on m.id_matricula = re.id_matricula "
				+ " inner join estudiantes e on e.id_estudiante = m.id_estudiante "
				+ " inner join persona p on p.id_persona = e.id_persona "
				+ " inner join periodo pe on pe.id_periodo = m.id_periodo "
				+ " inner join modalidad mo on mo.id_modalidad = m.id_modalidad "
				+ " inner join curso c on c.id_curso = m.id_curso "
				+ " inner join paralelo pa on pa.id_paralelo  = m.id_paralelo "
				+ " inner join malla_curso mc on mc.id_curso = c.id_curso "
				+ " inner join malla m2 on m2.id_malla = mc.id_malla "
				+ " inner join malla_asignatura mas on mas.id_malla = m2.id_malla "
				+ " inner join asignatura a on a.id_asignatura = mas.id_asignatura "
				+ " where pe.id_periodo =?1 and mo.id_modalidad=?2 and c.id_curso =?3 and pa.id_paralelo =?4 and a.id_asignatura =?5 ",nativeQuery=true)
		List<Registro> filtrocompleto(Long id_periodo, Long id_modalidad, Long id_curso, Long id_paralelo, Long id_asignatura);
	

}
