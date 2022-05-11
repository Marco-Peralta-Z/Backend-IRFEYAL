package com.irfeyal.servicio.tutorias;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.tutorias.IRegistroService;
import com.irfeyal.modelo.dao.parametrizacionacademica.AsignaturaRepository;
import com.irfeyal.modelo.dao.parametrizacionacademica.CursoRepository;
import com.irfeyal.modelo.dao.parametrizacionacademica.ModalidadRepository;
import com.irfeyal.modelo.dao.parametrizacionacademica.ParaleloRespository;
import com.irfeyal.modelo.dao.parametrizacionacademica.PeriodoRepository;
import com.irfeyal.modelo.dao.tutorias.IRegistroDao;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Paralelo;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;
import com.irfeyal.modelo.tutorias.Registro;


@Service
public class RegistroServiceImpl implements IRegistroService {
	
	@Autowired
	
	private IRegistroDao iregistrodao;
	
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
	
	public Registro save(Registro registro) {
		return iregistrodao.save(registro);
	}
	
	
	//Listar Registros
	public ArrayList<Registro>listarRegistro(){
		return (ArrayList<Registro>) iregistrodao.findAll(); 
	}
	
	// buscar por id
		@Override
		//@Transactional(readOnly = true)
		public Registro findById(Long id_registro) {
			// TODO Auto-generated method stub
			return iregistrodao.findById(id_registro).orElse(null);
		}
		
		@Override
		@Transactional 
		public void delete(Long id_registro) {	
			iregistrodao.deleteById(id_registro);
		}


		@Override
		public ArrayList<Registro> findAll() {
			// TODO Auto-generated method stub
			return null;
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
		public List<Curso> ListCursosempelados(Long empleado, Long id_modalidad) {
			return curso.ListCursosempelados(empleado, id_modalidad);
		}


		@Override
		public List<Paralelo> ListParaleloempleados(Long empleado, Long id_curso) {
			return paralelo.ListParaleloempleados(empleado, id_curso);
		}


		@Override
		public List<Asignatura> ListAsignaturaempleados(Long empleado, Long id_periodo, Long id_curso,
				Long id_paralelo) {
			return asignatura.ListAsignaturaempleados(empleado, id_periodo, id_curso, id_paralelo);
		}


		@Override
		public List<Modalidad> listmodalidadempelados(Long empleado, Long id_periodo) {
			return modalidad.listmodalidadempelados(empleado, id_periodo);
		}

		
}
