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
				+ "	where asigemple.id_empleado=?1 and p.id_periodo=?2",nativeQuery=true)
	List<Modalidad> listarmodalidadasistencia(Long empelado , Long idperiodo);
	
	
	/*MODULO TUTORIAS*/
	
	@Query(value = "SELECT mo.id_modalidad, mo.descripcion  FROM periodo p join  malla m on p.id_malla = m.id_malla "
			+ "	join malla_asignatura ma on ma.id_malla = m.id_malla "
			+ "	join asignatura asig on asig.id_asignatura = ma.id_asignatura "
			+ "	join asignatura_empleado asigemple on asigemple.id_asignatura = asig.id_asignatura "
			+ "	join modalidad mo on m.id_modalidad=mo.id_modalidad "
			+ "	where asigemple.id_empleado=?1 and p.id_periodo=?2", nativeQuery = true)
	List<Modalidad> listmodalidadempelados(Long empleado, Long id_periodo);
	
	
//	Modulo Matricula 
	
	@Query(value = "SELECT m.id_modalidad, m.descripcion,m.hora_inicio, m.hora_fin from modalidad_curso mc join "
			+ "modalidad m on m.id_modalidad = mc.id_modalidad where mc.id_curso=?1", nativeQuery = true)
	List<Modalidad> findByCurso(Long id_curso);
	
}
