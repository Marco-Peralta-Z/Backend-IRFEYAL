package com.irfeyal.modelo.dao.matricula;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.irfeyal.modelo.matricula.Estudiante;
import com.irfeyal.modelo.rolseguridad.Persona;

public interface IEstudianteDao  extends CrudRepository<Estudiante, Long> {
	
	
	Page<Estudiante> findAll(Pageable pageable);
	
	
	@Query(value = "select e from Estudiante e join "
			+ "Persona p on p.id_persona = e.id_persona where p.cedula like :cedula", nativeQuery = false)
	Estudiante findByCedula(@Param("cedula") String cedula );
	
	@Query(value="select p from Persona p join Estudiante e on p.id_persona= e.id_persona" , nativeQuery = false)
	List<Persona> findAllPersonas();
	
	//-----------------------Modulo Asistencia--------------------
	
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ "FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "where m.id_modalidad=?1",nativeQuery=true)
	List<Estudiante> buscarcursomodalidad(Long id_mod);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ "FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "where m.id_periodo=?1",nativeQuery=true)
	List<Estudiante> buscarcursoperiodo(Long id_periodo);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ "FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "where m.id_paralelo=?1",nativeQuery=true)
	List<Estudiante> buscarcursoparalelo(Long id_paralelo);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ " FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "left JOIN malla_curso l on m.id_curso= l.id_curso "
			+ "left join malla_asignatura a on l.id_malla= a.id_malla  "
			+ "left join asignatura s on a.id_asignatura= s.id_asignatura "
			+ "where s.id_asignatura=?1 group by e.id_estudiante",nativeQuery=true)
	List<Estudiante> buscarcursoasignatura(Long id_asignatura);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ "FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "where m.id_curso=?1 group by e.id_estudiante",nativeQuery=true)
	List<Estudiante> buscarcursocurso(Long id_curso);
	
	
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ "FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "where m.id_modalidad=?1 and m.id_periodo=?2" ,nativeQuery=true)
	List<Estudiante> buscarcursomodperi(Long id_mod, Long id_periodo);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ "FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "where m.id_modalidad=?1 and m.id_paralelo=?2",nativeQuery=true)
	List<Estudiante> buscarcursomodpar(Long id_mod, Long id_paralelo);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ " FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "left JOIN malla_curso l on m.id_curso= l.id_curso "
			+ "left join malla_asignatura a on l.id_malla= a.id_malla  "
			+ "left join asignatura s on a.id_asignatura= s.id_asignatura "
			+ "where m.id_modalidad=?1 and s.id_asignatura=?2  ",nativeQuery=true)
	List<Estudiante> buscarcursomodasig(Long id_mod, Long id_asignatura);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ "FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "where m.id_modalidad=?1 and m.id_curso=?2",nativeQuery=true)
	List<Estudiante> buscarcursomodcur(Long id_mod, Long id_curso);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ "FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "where m.id_periodo=?1 and m.id_paralelo=?2",nativeQuery=true)
	List<Estudiante> buscarcursoperipar(Long id_periodo, Long id_paralelo);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ " FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "left JOIN malla_curso l on m.id_curso= l.id_curso "
			+ "left join malla_asignatura a on l.id_malla= a.id_malla  "
			+ "left join asignatura s on a.id_asignatura= s.id_asignatura "
			+ "where m.id_periodo=?1 and s.id_asignatura=?2  ",nativeQuery=true)
	List<Estudiante> buscarcursoperiasig(Long id_periodo, Long id_asignatura);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ "FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "where m.id_periodo=?1 and m.id_curso=?2",nativeQuery=true)
	List<Estudiante> buscarcursopericur(Long id_periodo, Long id_curso);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ " FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "left JOIN malla_curso l on m.id_curso= l.id_curso "
			+ "left join malla_asignatura a on l.id_malla= a.id_malla  "
			+ "left join asignatura s on a.id_asignatura= s.id_asignatura "
			+ "where m.id_paralelo=?1 and s.id_asignatura=?2  ",nativeQuery=true)
	List<Estudiante> buscarcursoparasig(Long id_paralelo, Long id_asignatura);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ "FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "where  m.id_paralelo=?1 and m.id_curso=?2",nativeQuery=true)
	List<Estudiante> buscarcursoparcur(Long id_paralelo, Long id_curso);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ " FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "left JOIN malla_curso l on m.id_curso= l.id_curso "
			+ "left join malla_asignatura a on l.id_malla= a.id_malla  "
			+ "left join asignatura s on a.id_asignatura= s.id_asignatura "
			+ "where s.id_asignatura=?1 and m.id_curso=?2  ",nativeQuery=true)
	List<Estudiante> buscarcursoasigcur( Long id_asignatura,Long id_curso);
	
	
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ "FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "where m.id_modalidad=?1 and m.id_periodo=?2 and m.id_paralelo=?3",nativeQuery=true)
	List<Estudiante> buscarcursomodperpar(Long id_mod, Long id_periodo, Long id_paralelo);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ " FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "left JOIN malla_curso l on m.id_curso= l.id_curso "
			+ "left join malla_asignatura a on l.id_malla= a.id_malla  "
			+ "left join asignatura s on a.id_asignatura= s.id_asignatura "
			+ "where m.id_modalidad=?1 and m.id_periodo=?2 and s.id_asignatura=?3 ",nativeQuery=true)
	List<Estudiante> buscarcursomodperasig(Long id_mod, Long id_periodo, Long id_asignatura);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ "FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "where m.id_modalidad=?1 and m.id_periodo=?2 and m.id_curso=?3",nativeQuery=true)
	List<Estudiante> buscarcursomodpercur(Long id_mod, Long id_periodo, Long id_curso);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ " FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "left JOIN malla_curso l on m.id_curso= l.id_curso "
			+ "left join malla_asignatura a on l.id_malla= a.id_malla  "
			+ "left join asignatura s on a.id_asignatura= s.id_asignatura "
			+ "where m.id_modalidad=?1 and m.id_paralelo=?2 and s.id_asignatura=?3 ",nativeQuery=true)
	List<Estudiante> buscarcursomodparasig(Long id_mod, Long id_paralelo, Long id_asignatura);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ "FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "where m.id_modalidad=?1 and m.id_paralelo=?2 and m.id_curso=?3",nativeQuery=true)
	List<Estudiante> buscarcursomodparcur(Long id_mod, Long id_paralelo, Long id_curso);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ " FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "left JOIN malla_curso l on m.id_curso= l.id_curso "
			+ "left join malla_asignatura a on l.id_malla= a.id_malla  "
			+ "left join asignatura s on a.id_asignatura= s.id_asignatura "
			+ "where m.id_modalidad=?1 and s.id_asignatura=?2  and m.id_curso=?3",nativeQuery=true)
	List<Estudiante> buscarcursomodasigcur(Long id_mod, Long id_asignatura, Long id_curso);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ " FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "left JOIN malla_curso l on m.id_curso= l.id_curso "
			+ "left join malla_asignatura a on l.id_malla= a.id_malla  "
			+ "left join asignatura s on a.id_asignatura= s.id_asignatura "
			+ "where m.id_periodo=?1 and m.id_paralelo=?2 and s.id_asignatura=?3 ",nativeQuery=true)
	List<Estudiante> buscarcursoperparasig(Long id_periodo, Long id_paralelo, Long id_asignatura);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ "FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "where m.id_periodo=?1 and m.id_paralelo=?2 and m.id_curso=?3",nativeQuery=true)
	List<Estudiante> buscarcursoperparcur( Long id_periodo, Long id_paralelo,Long id_curso);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ " FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "left JOIN malla_curso l on m.id_curso= l.id_curso "
			+ "left join malla_asignatura a on l.id_malla= a.id_malla  "
			+ "left join asignatura s on a.id_asignatura= s.id_asignatura "
			+ "where m.id_periodo=?1 and s.id_asignatura=?2 and m.id_curso=?3 ",nativeQuery=true)
	List<Estudiante> buscarcursoperasigcur( Long id_periodo, Long id_asignatura,Long id_curso);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ " FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "left JOIN malla_curso l on m.id_curso= l.id_curso "
			+ "left join malla_asignatura a on l.id_malla= a.id_malla  "
			+ "left join asignatura s on a.id_asignatura= s.id_asignatura "
			+ "where m.id_paralelo=?1 and s.id_asignatura=?2 and m.id_curso=?3 ",nativeQuery=true)
	List<Estudiante> buscarcursoparasigcur( Long id_paralelo, Long id_asignatura,Long id_curso);
	
	
	
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ " FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "left JOIN malla_curso l on m.id_curso= l.id_curso "
			+ "left join malla_asignatura a on l.id_malla= a.id_malla  "
			+ "left join asignatura s on a.id_asignatura= s.id_asignatura "
			+ "where m.id_modalidad=?1 and m.id_periodo=?2 and m.id_paralelo=?3 and s.id_asignatura=?4  ",nativeQuery=true)
	List<Estudiante> buscarcursomodperparasig(Long id_mod, Long id_periodo, Long id_paralelo, Long id_asignatura);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ "FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "where m.id_modalidad=?1 and m.id_periodo=?2 and m.id_paralelo=?3 and m.id_curso=?4",nativeQuery=true)
	List<Estudiante> buscarcursomodperparcur( Long id_mod, Long id_periodo, Long id_paralelo,Long id_curso);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ " FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "left JOIN malla_curso l on m.id_curso= l.id_curso "
			+ "left join malla_asignatura a on l.id_malla= a.id_malla  "
			+ "left join asignatura s on a.id_asignatura= s.id_asignatura "
			+ "where m.id_modalidad=?1 and m.id_periodo=?2 and s.id_asignatura=?3 and m.id_curso=?4 ",nativeQuery=true)
	List<Estudiante> buscarcursomodperasigcur(Long id_mod, Long id_periodo, Long id_asignatura,Long id_curso);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ " FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "left JOIN malla_curso l on m.id_curso= l.id_curso "
			+ "left join malla_asignatura a on l.id_malla= a.id_malla  "
			+ "left join asignatura s on a.id_asignatura= s.id_asignatura "
			+ "where m.id_modalidad=?1 and m.id_paralelo=?2 and s.id_asignatura=?3 and m.id_curso=?4 ",nativeQuery=true)
	List<Estudiante> buscarcursomodparasigcur(Long id_mod, Long id_paralelo, Long id_asignatura,Long id_curso);
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ " FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "left JOIN malla_curso l on m.id_curso= l.id_curso "
			+ "left join malla_asignatura a on l.id_malla= a.id_malla  "
			+ "left join asignatura s on a.id_asignatura= s.id_asignatura "
			+ "where m.id_periodo=?1 and m.id_paralelo=?2 and s.id_asignatura=?3 and m.id_curso=?4 ",nativeQuery=true)
	List<Estudiante> buscarcursoperparasigcur(Long id_periodo, Long id_paralelo, Long id_asignatura,Long id_curso);

	
	
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ " FROM Estudiantes e "
			+ "RIGHT JOIN matriculas m on e.id_estudiante=m.id_estudiante "
			+ "left JOIN malla_curso l on m.id_curso= l.id_curso "
			+ "left join malla_asignatura a on l.id_malla= a.id_malla  "
			+ "left join asignatura s on a.id_asignatura= s.id_asignatura "
			+ "where m.id_modalidad=?1 and m.id_periodo=?2 and m.id_paralelo=?3 and s.id_asignatura=?4 and m.id_curso=?5 group by e.id_estudiante ",nativeQuery=true)
	List<Estudiante> buscarcursotodofil(Long id_mod, Long id_periodo, Long id_paralelo, Long id_asignatura,Long id_curso);
	
	
	
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ "FROM Estudiantes e "
			+ "INNER JOIN Persona p ON e.id_persona =p.id_persona "
			+ "WHERE p.cedula =?1",nativeQuery=true)
	Estudiante buscarcedulaestudiante(String cedula);
	
	/*MUESTRA LOS ESTUDIANTES EN BASE AL DOCENTE INGRESADO*/
	@Query(value="SELECT e.id_estudiante,e.estado_estudiante,e.id_correo,e.id_direccion,e.id_extension,e.id_persona,e.id_telefono "
			+ "FROM clase c JOIN asistencia a ON a.id_clase=c.id_clase "
			+ "JOIN estudiantes e  on e.id_estudiante = a.id_estudiante "
			+ "WHERE c.id_docente_id_rolusuario=?1",nativeQuery=true)
	List<Estudiante> cargarest( Integer iddocente);
	
	@Query(value="SELECT * FROM Estudiantes e "
			+ "WHERE e.id_estudiante=?1",nativeQuery=true)
	List<Estudiante> findestudianteid(Long idestu);
	
	
	@Query(value="SELECT * FROM Estudiantes e "
			+ "WHERE e.id_estudiante=?1",nativeQuery=true)
	Estudiante findestudianteidpdf(Long idestu);
	//-----------------------------Fin Modulo Asistencia-----------------------
	
	
	// -------------------- modulo inventario buscar por cedula list -----------------
	@Query(value = "select e from Estudiante e where e.id_persona.cedula like %?1%")
	public List<Estudiante> findAllByCedula(String cedula);

}
