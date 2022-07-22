package com.irfeyal.interfaces.tutorias;

import java.util.List;
import com.irfeyal.modelo.pagos.Comprobante;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Malla;
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

	public List<Malla> ListMalla(Long empleado, Long id_periodo);

	public List<Modalidad> listmodalidadempelados(Long empleado, Long id_periodo, Long id_malla);

	public List<Curso> ListCursosempelados(Long empleado, Long id_periodo, Long id_malla, Long id_modalidad);

	public List<Paralelo> ListParaleloempleados(Long empleado, Long id_periodo, Long id_malla, Long id_modalidad,
			Long id_curso);

	public List<Asignatura> ListAsignaturaempleados(Long empleado, Long id_periodo, Long id_malla, Long id_modalidad,
			Long id_curso, Long id_paralelo);

	public List<Registro> filtrocompleto(Long id_empleado, Long id_periodo, Long id_malla, Long id_modalidad,
			Long id_curso, Long id_paralelo, Long id_asignatura);

	public Comprobante buscarceduestudiante(String cedula);

	public void update(Registro registro, Long id_registro);

	public Registro cargardatos(Long matricula);

	// Para secretaria, certificado de promocion
	public List<Registro> findByCedulaEstudiante(String cedula);

	public List<Registro> getAllRegistrosByMatriculaId(Long id);

	public List<Registro> getAllRegistrosByCursoModalidadPeridod(Long idCurso, Long idModalidad, Long idPeriodo, Long idParalelo);

}
