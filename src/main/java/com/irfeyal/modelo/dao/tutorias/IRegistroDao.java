package com.irfeyal.modelo.dao.tutorias;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.irfeyal.modelo.tutorias.Registro;

public interface IRegistroDao extends JpaRepository<Registro, Long> {

	// Para secretaria, certificado de promocion
	@Query(value = "select r from Registro r where r.id_matricula.estudiante.id_persona.cedula like %?1% and r.estado = 'APROBADO'")
	public List<Registro> findByCedulaEstudiante(String cedula);

	@Query(value = "SELECT p.cedula,p.nombre,p.apellido,re.id_registro, re.aporte1, re.aporte2, re.examen_Iquimestre, re.promedio_Iquimestre, "
			+ "re.aporte3, re.aporte4, re.examen_IIquimestre,re.promedio_IIquimestre,re.conducta, re.nota_final, re.examen_supletorio, re.examen_remedial, re.examen_gracia, re.estado, re.fkid_asignatura, re.id_matricula, re.promedio_final  "
			+ "				 FROM registro re "
			+ "				 inner join matriculas m  on m.id_matricula = re.id_matricula "
			+ "				 inner join estudiantes e on e.id_estudiante = m.id_estudiante "
			+ "				 inner join persona p on p.id_persona = e.id_persona "
			+ "				 inner join periodo pe on pe.id_periodo = m.id_periodo "
			+ "				 inner join malla m2 on m2.id_malla = pe.id_malla "
			+ "				 inner join modalidad m3 on m3.id_modalidad = m2.id_modalidad "
			+ "				 inner join curso c on c.id_curso = m.id_curso "
			+ "				 inner join paralelo p2 on p2.id_paralelo = m.id_paralelo "
			+ "				 inner join malla_asignatura ma on ma.id_malla = m2.id_malla "
			+ "				 inner join asignatura a ON ma.id_asignatura = a.id_asignatura "
			+ "				 inner join tutor tuto on tuto.id_paralelo = p2.id_paralelo"
			//+ "				 inner join asignatura_empleado ae on ae.id_asignatura = a.id_asignatura "
			+ "				 where tuto.id_empleado= ?1  and pe.id_periodo =?2 and m2.id_malla =?3 and m3.id_modalidad =?4 and c.id_curso =?5 and p2.id_paralelo =?6 and re.fkid_asignatura =?7 "
			+ "			 	 group by p.cedula,p.nombre,p.apellido,re.id_registro, re.aporte1, re.aporte2, re.aporte3, re.aporte4 ,re.fkid_asignatura, re.id_matricula "
			+ "				 order by p.apellido ", nativeQuery = true)
	List<Registro> filtrocompleto(Long id_empleado, Long id_periodo, Long id_malla, Long id_modalidad, Long id_curso,
			Long id_paralelo, Long id_asignatura);

	@Query(value = "select r from Registro r where r.id_matricula.id_matricula = ?1 and r.estado = 'APROBADO'")
	public List<Registro> getAllRegistrosByMatriculaId(Long id);

	@Query(value = "select r from Registro r where r.estado = 'APROBADO' and r.id_matricula.curso.id_curso = ?1 and r.id_matricula.modalidad.id_modalidad =?2 and r.id_matricula.id_periodo.id_periodo =?3")
	public List<Registro> getAllRegistrosByCursoModalidadPeridod(Long idCurso, Long idModalidad, Long idPeridod);

}
