package com.irfeyal.interfaces.tutorias;

import java.util.ArrayList;
import java.util.List;

import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Paralelo;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;
import com.irfeyal.modelo.tutorias.Registro;


public interface IRegistroService {

	
	public Registro save(Registro registro);
	public ArrayList<Registro> findAll();
	public void delete(Long id_registro);
	public Registro findById(Long id_registro);
	public List<Periodo> findAllperiodo();
	
	
	
	public List<Periodo> Listperiodosempelados(Long empleado);
	public List<Modalidad> listmodalidadempelados(Long empleado, Long id_periodo);
	public List<Curso> ListCursosempelados(Long empleado, Long id_modalidad);
	public List<Paralelo> ListParaleloempleados(Long empleado, Long id_curso);
	public List<Asignatura> ListAsignaturaempleados(Long empleado, Long id_periodo, Long id_curso, Long id_paralelo);


}
