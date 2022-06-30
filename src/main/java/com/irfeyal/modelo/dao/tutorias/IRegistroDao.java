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
	

		@Query(value=" SELECT p.cedula,p.nombre,p.apellido,re.id_registro, re.aporte1, re.aporte2, re.examen_Iquimestre, re.promedio_Iquimestre, re.aporte3, re.aporte4, re.examen_IIquimestre,re.promedio_IIquimestre, re.examen_supletorio, re.examen_remedial, re.examen_gracia, re.nota_final, re.fkid_asignatura, re.id_matricula "
				+ "	 FROM registro re "
				+ "	 inner join matriculas m  on m.id_matricula = re.id_matricula "
				+ "	 inner join estudiantes e on e.id_estudiante = m.id_estudiante "
				+ "	 inner join persona p on p.id_persona = e.id_persona "
				+ "	 inner join periodo pe on pe.id_periodo = m.id_periodo "
				+ "	 inner join malla m2 on m2.id_malla = pe.id_malla "
				+ "	 inner join modalidad m3 on m3.id_modalidad = m2.id_modalidad "
				+ "	 inner join curso c on c.id_curso = m.id_curso "
				+ "	 inner join paralelo p2 on p2.id_paralelo = m.id_paralelo "
				+ "	 inner join malla_asignatura ma on ma.id_malla = m2.id_malla "
				+ "	 where pe.id_periodo =?1 and m2.id_malla =?2 and m3.id_modalidad =?3 and c.id_curso =?4 and p2.id_paralelo =?5 and ma.id_asignatura =?6",nativeQuery=true)
		List<Registro> filtrocompleto(Long id_periodo,Long id_malla , Long id_modalidad, Long id_curso, Long id_paralelo, Long id_asignatura);
	

}
