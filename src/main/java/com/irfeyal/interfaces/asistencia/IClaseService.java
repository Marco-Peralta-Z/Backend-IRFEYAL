package com.irfeyal.interfaces.asistencia;

import java.util.Date;
import java.util.List;

import com.irfeyal.modelo.asistencia.Clase;
import com.irfeyal.modelo.rolseguridad.Empleado;
import com.irfeyal.modelo.rolseguridad.Usuario;

public interface IClaseService {
	public Clase save(Clase clase);
	public List<Clase> findAll();
	public List<Clase>validarclase(Integer iddocente,Integer idperiodo,Integer idmodalidad, Integer idcurso,
			Integer idparalelo,Integer idasignatura,Date fecha);
	public List<Clase>mostrarfechas(Long idestudiante, Integer iddocente,Integer idasignatura,Integer idcurso,Integer idparalelo,Integer idmodalidad,Integer idperiodo);
	public Clase findById(Long id);
	 public Clase ultimoingreso();
	 
		public Long validarclass(Integer iddocente,Integer idperiodo,Integer idmodalidad, Integer idcurso,
				Integer idparalelo,Integer idasignatura,Date fecha);

}
