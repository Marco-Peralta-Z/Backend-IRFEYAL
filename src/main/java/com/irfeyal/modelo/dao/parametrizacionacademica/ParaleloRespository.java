package com.irfeyal.modelo.dao.parametrizacionacademica;

import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Paralelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParaleloRespository extends JpaRepository<Paralelo, Long> {
	@Query(value="SELECT  p.id_paralelo,p.descripcion,p.fecha_creacion  "
			+ "FROM  paralelo p "
			+ "join curso_paralelo cp on cp.id_paralelo = p.id_paralelo "
			+ "join curso c on c.id_curso = cp.id_curso  "
			+ "where c.id_empleado=?1  and c.id_curso=?2 group by p.id_paralelo",nativeQuery=true)
	List<Paralelo> listarparaleloasistencia(Long empelado , Long idcurso);
}
