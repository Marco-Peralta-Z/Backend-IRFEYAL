package com.irfeyal.servicio.tutorias;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.tutorias.IRegistroService;
import com.irfeyal.modelo.dao.matricula.IMatriculaDao;
import com.irfeyal.modelo.dao.pagos.IComprobanteDao;
import com.irfeyal.modelo.dao.parametrizacionacademica.AsignaturaRepository;
import com.irfeyal.modelo.dao.parametrizacionacademica.CursoRepository;
import com.irfeyal.modelo.dao.parametrizacionacademica.ModalidadRepository;
import com.irfeyal.modelo.dao.parametrizacionacademica.ParaleloRespository;
import com.irfeyal.modelo.dao.parametrizacionacademica.PeriodoRepository;
import com.irfeyal.modelo.dao.tutorias.IRegistroDao;
import com.irfeyal.modelo.matricula.Matricula;
import com.irfeyal.modelo.pagos.Comprobante;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Paralelo;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;
import com.irfeyal.modelo.tutorias.Registro;


@Service
public class RegistroServiceImpl implements IRegistroService {
	
	@Autowired
	private IRegistroDao registrodao;
	
	@Autowired
	private PeriodoRepository periodo;
	
	@Autowired
	private ModalidadRepository modalidad;
	
	@Autowired
	private CursoRepository curso;
	
	@Autowired
	private ParaleloRespository paralelo;
	
	@Autowired
	private AsignaturaRepository asignatura;
	
	@Autowired
	private IMatriculaDao matricula;
	
	@Autowired
	private IComprobanteDao comprobante;
	
	public Registro save(Registro registro) {
		return registrodao.save(registro);
	}
	
	
	/*//Listar Registros
	public ArrayList<Registro>listarRegistro(){
		return (ArrayList<Registro>) iregistrodao.findAll(); 
	}*/
	
	// buscar por id
		@Override
		//@Transactional(readOnly = true)
		public Registro findById(Long id_registro) {
			// TODO Auto-generated method stub
			return registrodao.findById(id_registro).orElse(null);
		}
		
		@Override
		@Transactional 
		public void delete(Long id_registro) {	
			registrodao.deleteById(id_registro);
		}


		@Override
		public List<Periodo> findAllperiodo() {
			return periodo.findAll();
		}


		@Override
		public List<Periodo> Listperiodosempelados(Long empleado) {
			
			return periodo.Listperiodosempelados(empleado);
		}

		@Override
		public List<Curso> ListCursosempelados(Long empleado, Long id_modalidad, Long id_periodo) {
			return curso.ListCursosempelados(empleado, id_modalidad, id_periodo);
		}



		@Override
		public List<Modalidad> listmodalidadempelados(Long empleado, Long id_periodo) {
			return modalidad.listmodalidadempelados(empleado, id_periodo);
		}


		@Override
		public List<Registro> findAll() {
			
			return (List<Registro>)registrodao.findAll();
		}


		@Override
		public List<Paralelo> ListParaleloempleados(Long empleado, Long id_curso, Long id_periodo, Long id_modalidad) {
			return paralelo.ListParaleloempleados(empleado, id_curso, id_modalidad, id_periodo);
		}


		@Override
		public List<Asignatura> ListAsignaturaempleados(Long empleado, Long id_periodo, Long id_curso, Long id_paralelo,
				Long id_modalidad) {
			
			return asignatura.ListAsignaturaempleados(empleado, id_periodo, id_curso, id_paralelo, id_modalidad);
		}


		@Override
		public List<Matricula> filtrocompleto(Long id_periodo, Long id_modalidad, Long id_curso, Long id_paralelo,
				Long id_asignatura) {
			
			return matricula.filtrocompleto(id_periodo, id_modalidad, id_curso, id_paralelo, id_asignatura);
		}


		@Override
		public Comprobante buscarceduestudiante(String cedula) {
			
			return comprobante.buscarcedulaestudiante(cedula);
		}


	



		
}
