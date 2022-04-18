package com.irfeyal.interfaces.asistencia;

import java.util.List;

import com.irfeyal.modelo.asistencia.Asistencia;
import com.irfeyal.modelo.matricula.Estudiante;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.rolseguridad.Persona;

public interface IAsistenciaService {
	public List<Asistencia> findAll();
	public Asistencia findById(Long id);
	public Asistencia save(Asistencia asistencia);
	public void delete(Long id);
	public List <Persona> buscarcurso(Long id);
	public List <Estudiante> buscarcursomodalidad(Long id_mod,Long id_periodo,Long id_paralelo,Long id_asignatura);
	public Estudiante buscarceduestudiante(String cedula);
	
	public List<Modalidad> modalidaddocente(Integer id_docente);
}
