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
			+ "where asigemple.id_empleado=?1 and p.id_periodo=?2 and mo.id_modalidad=?3 and c.id_curso=?4"
			+ " group by pa.id_paralelo",nativeQuery=true)
	List<Paralelo> listarparaleloasistencia(Long empelado ,Long periodo, Long modalidad, Long idcurso);
	
	
	/* MODULO TUTORIAS */
	
	@Query(value = "select p.id_paralelo, p.descripcion, p.fecha_creacion from paralelo p "
			+ " inner join tutor t on t.id_paralelo = p.id_paralelo "
			+ " inner join curso c on c.id_curso = t.id_curso "
			+ " inner join malla_curso mc on mc.id_curso = c.id_curso "
			+ " inner join malla_asignatura ma on ma.id_malla = mc.id_malla "
			+ " inner join malla m on m.id_malla = ma.id_malla "
			+ " inner join periodo p2 on p2.id_malla = m.id_malla "
			+ " inner join modalidad m2 on m2.id_modalidad = m.id_modalidad "
			+ " inner join asignatura_empleado ae on ae.id_asignatura = ma.id_asignatura "
			+ " where ae.id_empleado =?1 and p2.id_periodo =?2 and m.id_malla =?3 and m2.id_modalidad =?4 and c.id_curso =?5 "
			+ " group by p.id_paralelo "
			+ " order by p.id_paralelo ", nativeQuery = true)
	List<Paralelo> ListParaleloempleados(Long empleado, Long id_periodo, Long id_malla, Long id_modalidad, Long id_curso);

//	Modulo Matricula
	@Query(value="select p.id_paralelo, p.descripcion, p.fecha_creacion from tutor t join paralelo p on t.id_paralelo = p.id_paralelo where t.id_curso =?1", nativeQuery=true)
	List<Paralelo> findParaleloByCurso(Long id_curso);
	
}
