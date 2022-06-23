package com.irfeyal.modelo.dao.matricula; 

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.irfeyal.modelo.matricula.Matricula;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;

public interface IMatriculaDao extends CrudRepository<Matricula, Long>{

	
	Page<Matricula> findAll(Pageable pageable);

	@Query(value="select m.id_matricula, m.fecha_matricula,m.id_curso, m,id_estudiante,m.id_paralelo, m.id_periodo,m.id_modalidad, m.id_usuario from matriculas m join periodo p on m.id_periodo = p.id_periodo where p.vigencia = true", nativeQuery = true)
	List<Matricula> matriculasActivas();
	
	/*MODULO TUTORIAS*/
	
	@Query(value=" select max(id_matricula) from matriculas ",nativeQuery=true)
	List<Long> id_matriculas();
	
	
	/*FIN MODULO TUTORIAS*/
	
	@Query(value="select m from Matricula m where m.estudiante.id_persona.cedula like %?1%")
	public List<Matricula> findByCedulaEstudiante(String cedula);
	
	
	@Query(value="select m.id_matricula, m.fecha_matricula,m.id_curso, m,id_estudiante,m.id_paralelo, m.id_periodo,m.id_modalidad, m.id_usuario from matriculas m where m.id_estudiante =?1", nativeQuery = true)
	public List<Matricula> findHistorialEstudianteMatricula(Long id);
		
}
