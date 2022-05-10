package com.irfeyal.interfaces.asistencia;

import java.util.Date;
import java.util.List;


import com.irfeyal.modelo.asistencia.Asistencia;
import com.irfeyal.modelo.matricula.Estudiante;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Paralelo;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;
import com.irfeyal.modelo.rolseguridad.Persona;

public interface IAsistenciaService {
	public List<Asistencia> findAll();
	public Asistencia findById(Long id);
	public Asistencia save(Asistencia asistencia);
	public void delete(Long id);
	public List <Persona> buscarcurso(Long id);
	public List <Estudiante> buscarcursomodalidad(Long id_mod,Long id_periodo,Long id_paralelo,Long id_asignatura, Long id_curs);
	public Estudiante buscarceduestudiante(String cedula);
	public List<Asignatura> findAllAsignaturas();
	public List<Paralelo>findAllParalelo();
	public List<Modalidad> findAllModalidad();
	public List<Periodo> findAllperio();
	public List<Curso>findAllcurso();
	public List<Estudiante>mostrarinformacion(long id);
	public List<Asistencia> burcarasistencia(Long id_mod, Long id_periodo, Long id_paralelo, Long id_asignatura,Long id_curso,Date fecha);
	
	public List<Periodo>listarpaeriodo(Long empleado);
	public List<Modalidad>listarmodalidad(Long emplead,Long idperiodo);
	public List<Curso>listarcurso(Long emplead,Long idmodalidad);
	public List<Paralelo> listarparalelo(Long emple,Long idcurso);
	public List<Asignatura> listarasignatura(Long empelado , Long idperiodo,Long idcurso,Long idparalelo);
	public List<Modalidad> modalidaddocente(Integer id_docente);
	public List<Asistencia>actualizarfiltros(Long id_mod, Long id_periodo, Long id_paralelo, Long id_asignatura,Long id_curso,Date fecha);
}
