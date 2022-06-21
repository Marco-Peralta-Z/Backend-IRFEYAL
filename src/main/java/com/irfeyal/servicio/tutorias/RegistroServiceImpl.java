package com.irfeyal.servicio.tutorias;


import java.util.List;
import java.util.Optional;

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


		@Override
		public Registro cargardatos(Long matricula) {
		
			Registro registro = new Registro();
			
			//Matricula matriculafinal = matricula;
			
			//registro.setId_matricula(matricula);
			
			registro.setAporte1(0);
			registro.setAporte2(0);
			registro.setAporte3(0);
			registro.setAporte4(0);
			registro.setEvaluacion1(0);
			registro.setAporte5(0);
			registro.setAporte6(0);
			registro.setAporte7(0);
			registro.setAporte8(0);
			registro.setEvaluacion2(0);
			registro.setExamenfinal(0);
			registro.setPromediofinal(0);
			registro.setExamen_supletorio(0);
			registro.setPromedio_supletorio(0);
			registro.setExamen_remedial(0);
			registro.setPromedio_remedial(0);
			registro.setExamen_gracia(0);
			registro.setPromedio_gracia(0);
			registro.setComportamiento(0);
			//registro.setId_asignatura(null);

			
			return registrodao.save(registro);
		}
		
		
		
		
		@Override
		public void update(Registro registro, Long id_registro) {
			Optional<Registro> editReporte = this.registrodao.findById(id_registro);
			Registro editar= editReporte.get();
			editar.setId_registro(registro.getId_registro());
			editar.setAporte1(registro.getAporte1());
			editar.setAporte2(registro.getAporte2());
			editar.setAporte3(registro.getAporte3());
			editar.setAporte4(registro.getAporte4());
			editar.setEvaluacion1(registro.getEvaluacion1());
			editar.setAporte5(registro.getAporte5());
			editar.setAporte6(registro.getAporte6());
			editar.setAporte7(registro.getAporte7());
			editar.setAporte8(registro.getAporte8());
			editar.setEvaluacion2(registro.getEvaluacion2());
			editar.setExamenfinal(registro.getExamenfinal());
			editar.setPromediofinal(registro.getPromediofinal());
			editar.setExamen_supletorio(registro.getExamen_supletorio());
			editar.setPromedio_supletorio(registro.getPromedio_supletorio());
			editar.setExamen_remedial(registro.getExamen_remedial());
			editar.setPromedio_remedial(registro.getPromedio_remedial());
			editar.setExamen_gracia(registro.getExamen_gracia());
			editar.setPromedio_gracia(registro.getPromedio_gracia());
			editar.setComportamiento(registro.getComportamiento());	
			editar.setId_asignatura(registro.getId_asignatura());
			editar.setId_matricula(registro.getId_matricula());
			this.registrodao.save(editar);
		}

		//Para secretaria, certificado de promocion
		@Override
		public List<Registro> findByCedulaEstudiante(String cedula) {
					
			return registrodao.findByCedulaEstudiante(cedula);
		}
		


		


	



		
}
