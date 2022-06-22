package com.irfeyal.interfaces.tutorias;

//import java.util.ArrayList;
import java.util.List;

import com.irfeyal.modelo.matricula.Matricula;
import com.irfeyal.modelo.pagos.Comprobante;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Paralelo;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;
import com.irfeyal.modelo.tutorias.Registro;


public interface IRegistroService {

	
	public Registro save(Registro registro);
	public List<Registro> findAll();
	public void delete(Long id_registro);
	public Registro findById(Long id_registro);
	public List<Periodo> findAllperiodo();
	
	
	
	public List<Periodo> Listperiodosempelados(Long empleado);
	public List<Modalidad> listmodalidadempelados(Long empleado, Long id_periodo);
	public List<Curso> ListCursosempelados(Long empleado, Long id_modalidad, Long id_periodo);
	public List<Paralelo> ListParaleloempleados(Long empleado, Long id_curso, Long id_modalidad, Long id_periodo);
	public List<Asignatura> ListAsignaturaempleados(Long empleado, Long id_periodo, Long id_curso, Long id_paralelo, Long id_modalidad);
	public List<Matricula> filtrocompleto(Long id_periodo, Long id_modalidad, Long id_curso, Long id_paralelo, Long id_asignatura);
	public Comprobante buscarceduestudiante(String cedula);
	
	public  void update(Registro registro, Long id_registro);
	
	public Registro cargardatos (Long matricula);
	
	//Para secretaria, certificado de promocion
	public List<Registro> findByCedulaEstudiante(String cedula);


}
