package com.irfeyal.modelo.dao.secretaria;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.irfeyal.modelo.secretaria.GenerarCertificadoPromocion;

public interface IGenerarCertificadoPromocionDao extends CrudRepository<GenerarCertificadoPromocion, Long>{
	
	Page<GenerarCertificadoPromocion> findAll(Pageable pageable);
	
	@Query(value="select gp from GenerarCertificadoPromocion gp where gp.registro.id_matricula.estudiante.id_persona.cedula like %?1%")
	public List<GenerarCertificadoPromocion> findByCedulaEstudiante(String cedula);
	
	//Filtrar promedios 1erQuimestre, 2doQuimestre y promedio final por curso paralelo modalidad y periodo
		@Query(value="SELECT p.nombre, p.apellido, a.id_asignatura, a.descripcion,p.cedula, re.promedio_iquimestre, re.promedio_iiquimestre, re.nota_final, re.promedio_final, re.conducta  FROM registro re"
				+ "		inner join matriculas m  on m.id_matricula = re.id_matricula"
				+ "		inner join estudiantes e on e.id_estudiante = m.id_estudiante"
				+ "		inner join persona p on p.id_persona = e.id_persona"
				+ "		inner join asignatura a on a.id_asignatura = re.fkid_asignatura"
				+ "		inner join periodo pe on pe.id_periodo = m.id_periodo"
				+ "		inner join malla m2 on m2.id_malla = pe.id_malla"
				+ "		inner join modalidad m3 on m3.id_modalidad = m2.id_modalidad"
				+ "		inner join curso c on c.id_curso = m.id_curso"
				+ "		inner join paralelo p2 on p2.id_paralelo = m.id_paralelo"
				+ "		where pe.id_periodo =?1 and m3.id_modalidad =?2 and c.id_curso =?3 and p2.id_paralelo =?4",nativeQuery=true)
		List<String> cargarnotasgeneral(Long periodo, Long modalidad, Long curso, Long paralelo); 
	
}
