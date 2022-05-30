package com.irfeyal.modelo.dao.parametrizacionacademica;

import com.irfeyal.modelo.parametrizacionacademica.Periodo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Long> {
	
	
	/*MODULO ASISTENCIA*/
	
	@Query(value="SELECT *  FROM periodo p join  malla m on p.id_malla = m.id_malla  "
			+ "join malla_asignatura ma on ma.id_malla = m.id_malla "
			+ "join asignatura asig on asig.id_asignatura = ma.id_asignatura "
			+ "join asignatura_empleado asigemple on asigemple.id_asignatura = asig.id_asignatura "
			+ "	where asigemple.id_empleado=?1",nativeQuery=true)
	List<Periodo> listarperiodoasistencia(Long empelado);
	
	
	/* MODULO TUTORIAS  */
	
	@Query (value = "	select * from periodo p "
			+ "	inner join malla m on m.id_malla = p.id_malla "
			+ "	inner join malla_curso mc on mc.id_malla = m.id_malla "
			+ "	inner join curso c on c.id_curso = mc.id_curso "
			+ "	where c.id_empleado=?1", nativeQuery = true)
	List<Periodo> Listperiodosempelados(Long empleado);
	

}
