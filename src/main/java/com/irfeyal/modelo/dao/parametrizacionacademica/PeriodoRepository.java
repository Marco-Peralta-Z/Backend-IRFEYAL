package com.irfeyal.modelo.dao.parametrizacionacademica;

import com.irfeyal.modelo.matricula.Estudiante;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Long> {
	@Query(value="SELECT *  "
			+ "FROM periodo p "
			+ "join  malla m on p.id_malla = m.id_malla  "
			+ "join malla_curso mc on mc.id_malla = m.id_malla "
			+ "join curso cur on cur.id_curso = mc.id_curso "
			+ "where cur.id_empleado=?1",nativeQuery=true)
	List<Periodo> listarperiodoasistencia(Long empelado);

}
