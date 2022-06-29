package com.irfeyal.modelo.dao.parametrizacionacademica;

import com.irfeyal.modelo.parametrizacionacademica.Malla;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MallaRepository extends JpaRepository<Malla, Long> {

	
/*MODULO TUTORIAS*/
	
	@Query(value = " select m.id_malla , m.descripcion , m.estado , m.fecha_creacion , m.id_modalidad  from malla m "
			+ " inner join periodo p on p.id_malla = m.id_malla "
			+ " inner join malla_asignatura ma on ma.id_malla = m.id_malla "
			+ " inner join asignatura a on a.id_asignatura = ma.id_asignatura "
			+ " inner join asignatura_empleado ae on ae.id_asignatura = a.id_asignatura "
			+ " where ae.id_empleado =?1 and p.id_periodo =?2"
			+ " group by m.id_malla ", nativeQuery = true)
	List<Malla> ListMalla(Long empleado, Long id_periodo);
	
}
