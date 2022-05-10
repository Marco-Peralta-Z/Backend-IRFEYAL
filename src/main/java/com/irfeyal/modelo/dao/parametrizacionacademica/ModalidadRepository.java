package com.irfeyal.modelo.dao.parametrizacionacademica;

import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalidadRepository extends JpaRepository<Modalidad, Long> {

	@Query(value="SELECT m.id_modalidad, m.descripcion,m.hora_inicio, m.hora_fin   "
			+ "FROM modalidad m "
			+ "join modalidad_curso mc  on m.id_modalidad = mc.id_modalidad  "
			+ "join curso c on c.id_curso = mc.id_curso "
			+ "join malla_curso mcur on mcur.id_curso = c.id_curso "
			+ "join malla mal on mal.id_malla = mcur.id_malla  "
			+ "join periodo per on per.id_malla = mal.id_malla  "
			+ "where  c.id_empleado=?1 and per.id_periodo=?2 group by m.id_modalidad",nativeQuery=true)
	List<Modalidad> listarmodalidadasistencia(Long empelado , Long idperiodo);
}
