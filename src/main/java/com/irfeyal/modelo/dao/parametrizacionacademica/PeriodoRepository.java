package com.irfeyal.modelo.dao.parametrizacionacademica;

import com.irfeyal.modelo.parametrizacionacademica.Periodo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Long> {
	
	
	/*MODULO ASISTENCIA*/
	
	@Query(value="SELECT p.id_periodo, p.ano_fin,p.ano_inicio,p.costo_matricula,p.costo_mensualidad,p.fecha_fin,p.fecha_inicio,p.vigencia,p.id_malla "
			+ "FROM periodo p join  malla m on p.id_malla = m.id_malla  "
			+ "join malla_asignatura ma on ma.id_malla = m.id_malla "
			+ "join asignatura asig on asig.id_asignatura = ma.id_asignatura "
			+ "join asignatura_empleado asigemple on asigemple.id_asignatura = asig.id_asignatura "
			+ "	where asigemple.id_empleado=?1"
			+ " group by p.id_periodo order by p.id_periodo",nativeQuery=true)
	List<Periodo> listarperiodoasistencia(Long empelado);
	
	
	/* MODULO TUTORIAS  */
	
	@Query (value = "SELECT p.id_periodo, p.ano_fin,p.ano_inicio,p.costo_matricula,p.costo_mensualidad,p.fecha_fin,p.fecha_inicio,p.vigencia,p.id_malla "
			+ " FROM periodo p join  malla m on p.id_malla = m.id_malla  "
			+ "	join malla_asignatura ma on ma.id_malla = m.id_malla "
			+ "	join asignatura asig on asig.id_asignatura = ma.id_asignatura "
			+ "	join asignatura_empleado asigemple on asigemple.id_asignatura = asig.id_asignatura "
			+ "	where asigemple.id_empleado=?1 "
			+ " group by p.id_periodo"
			+ " order by p.id_periodo ", nativeQuery = true)
	List<Periodo> Listperiodosempelados(Long empleado);
	

//	Modulo Matricula
	@Query(value="select * from periodo p where p.id_malla=?1 and p.vigencia= true", nativeQuery=true)
	List<Periodo> findByMalla(Long id_malla);


}
