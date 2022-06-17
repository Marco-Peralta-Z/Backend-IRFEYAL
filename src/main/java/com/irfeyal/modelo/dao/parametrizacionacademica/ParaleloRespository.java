package com.irfeyal.modelo.dao.parametrizacionacademica;


import com.irfeyal.modelo.parametrizacionacademica.Paralelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParaleloRespository extends JpaRepository<Paralelo, Long> {
	
	
	/* MODULO ASISTENCIA */
	
	@Query(value="SELECT pa.id_paralelo,pa.descripcion, pa.fecha_creacion "
			+ "FROM periodo p join  malla m on p.id_malla = m.id_malla  "
			+ "join malla_asignatura ma on ma.id_malla = m.id_malla "
			+ "join asignatura asig on asig.id_asignatura = ma.id_asignatura "
			+ "join asignatura_empleado asigemple on asigemple.id_asignatura = asig.id_asignatura "
			+ "join modalidad mo on m.id_modalidad=mo.id_modalidad "
			+ "join malla_curso mc on m.id_malla=mc.id_malla "
			+ "join curso c on mc.id_curso=c.id_curso "
			+ "join tutor t on c.id_curso=t.id_curso "
			+ "join paralelo pa on t.id_paralelo=pa.id_paralelo "
			+ "where asigemple.id_empleado=?1 and p.id_periodo=?2 and mo.id_modalidad=?3 and c.id_curso=?4",nativeQuery=true)
	List<Paralelo> listarparaleloasistencia(Long empelado ,Long periodo, Long modalidad, Long idcurso);
	
	
	/* MODULO TUTORIAS */
	
	@Query(value = "SELECT pa.id_paralelo,pa.descripcion, pa.fecha_creacion "
			+ " FROM periodo p join  malla m on p.id_malla = m.id_malla  "
			+ "	join malla_asignatura ma on ma.id_malla = m.id_malla "
			+ "	join asignatura asig on asig.id_asignatura = ma.id_asignatura "
			+ "	join asignatura_empleado asigemple on asigemple.id_asignatura = asig.id_asignatura "
			+ "	join modalidad mo on m.id_modalidad=mo.id_modalidad "
			+ "	join malla_curso mc on m.id_malla=mc.id_malla "
			+ "	join curso c on mc.id_curso=c.id_curso "
			+ "	join curso_paralelo cp on c.id_curso=cp.id_curso "
			+ "	join paralelo pa on cp.id_paralelo=pa.id_paralelo "
			+ "	where asigemple.id_empleado=?1 and p.id_periodo=?2 and mo.id_modalidad=?3 and c.id_curso=?4 ", nativeQuery = true)
	List<Paralelo> ListParaleloempleados(Long empleado, Long id_curso, Long id_modalidad, Long id_periodo);

//	Modulo Matricula
	@Query(value="select * from paralelo p join curso c on p.id_paralelo=c.id_paralelo where c.id_curso=?1", nativeQuery=true)
	List<Paralelo> findParaleloByCurso(Long id_curso);
	
}
