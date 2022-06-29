package com.irfeyal.modelo.dao.parametrizacionacademica;

import java.util.List;

import com.irfeyal.modelo.parametrizacionacademica.Modalidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalidadRepository extends JpaRepository<Modalidad, Long> {
	
	
	/*MODULO ASISTENCIA*/

		@Query(value="SELECT mo.id_modalidad, mo.descripcion  FROM periodo p join  malla m on p.id_malla = m.id_malla "
				+ "	join malla_asignatura ma on ma.id_malla = m.id_malla "
				+ "	join asignatura asig on asig.id_asignatura = ma.id_asignatura "
				+ "	join asignatura_empleado asigemple on asigemple.id_asignatura = asig.id_asignatura "
				+ "	join modalidad mo on m.id_modalidad=mo.id_modalidad "
				+ "	where asigemple.id_empleado=?1 and p.id_periodo=?2"
				+ " group by mo.id_modalidad",nativeQuery=true)
	List<Modalidad> listarmodalidadasistencia(Long empelado , Long idperiodo);
	
	
	/*MODULO TUTORIAS*/
	
	@Query(value = "select m.id_modalidad , m.descripcion, m.hora_fin, m.hora_inicio from modalidad m "
			+ " inner join malla m2 on m2.id_malla = m.id_modalidad "
			+ " inner join malla_asignatura ma on ma.id_malla = m2.id_malla "
			+ " inner join asignatura a on a.id_asignatura = ma.id_asignatura "
			+ " inner join asignatura_empleado ae on ae.id_asignatura = a.id_asignatura "
			+ " inner join periodo p on p.id_malla = m2.id_malla "
			+ " where ae.id_empleado =?1 and p.id_periodo =?2 and m2.id_malla =?3 "
			+ " group by m.id_modalidad", nativeQuery = true)
	List<Modalidad> listmodalidadempelados(Long empleado, Long id_periodo, Long id_malla);
	
//	Modulo Matricula 
	
	@Query(value = "SELECT m.id_modalidad, m.descripcion,m.hora_inicio, m.hora_fin from modalidad_curso mc join "
			+ "modalidad m on m.id_modalidad = mc.id_modalidad where mc.id_curso=?1", nativeQuery = true)
	List<Modalidad> findByCurso(Long id_curso);
	
}
