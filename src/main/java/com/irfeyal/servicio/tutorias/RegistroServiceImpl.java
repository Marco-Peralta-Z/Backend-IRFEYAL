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
import com.irfeyal.modelo.dao.parametrizacionacademica.MallaRepository;
import com.irfeyal.modelo.dao.parametrizacionacademica.ModalidadRepository;
import com.irfeyal.modelo.dao.parametrizacionacademica.ParaleloRespository;
import com.irfeyal.modelo.dao.parametrizacionacademica.PeriodoRepository;
import com.irfeyal.modelo.dao.tutorias.IRegistroDao;
import com.irfeyal.modelo.matricula.Matricula;
import com.irfeyal.modelo.pagos.Comprobante;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Malla;
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
	private MallaRepository malla;
	
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
		public List<Modalidad> listmodalidadempelados(Long empleado, Long id_periodo, Long id_malla) {
			return modalidad.listmodalidadempelados(empleado, id_periodo, id_malla);
		}


		@Override
		public List<Registro> findAll() {
			
			return (List<Registro>)registrodao.findAll();
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
			registro.setExamen_Iquimestre(0);
			registro.setPromedio_Iquimestre(0);
			registro.setAporte3(0);
			registro.setAporte4(0);
			registro.setExamen_IIquimestre(0);
			registro.setPromedio_IIquimestre(0);
			registro.setExamen_supletorio(0);
			registro.setExamen_remedial(0);
			registro.setExamen_gracia(0);
			registro.setNota_final(0);

			
			return registrodao.save(registro);
		}
		
		
		@Override
		public void update(Registro registro, Long id_registro) {
			Optional<Registro> editReporte = this.registrodao.findById(id_registro);
			Registro editar= editReporte.get();
			editar.setId_registro(registro.getId_registro());
			editar.setAporte1(registro.getAporte1());
			editar.setAporte2(registro.getAporte2());
			editar.setExamen_Iquimestre(registro.getExamen_Iquimestre());
			editar.setPromedio_Iquimestre(registro.getPromedio_Iquimestre());
			editar.setAporte3(registro.getAporte3());
			editar.setAporte4(registro.getAporte4());
			editar.setExamen_IIquimestre(registro.getExamen_IIquimestre());
			editar.setPromedio_IIquimestre(registro.getPromedio_IIquimestre());
			editar.setExamen_supletorio(registro.getExamen_supletorio());
			editar.setExamen_remedial(registro.getExamen_remedial());
			editar.setExamen_gracia(registro.getExamen_gracia());
			editar.setNota_final(registro.getNota_final());
			editar.setId_asignatura(registro.getId_asignatura());
			editar.setId_matricula(registro.getId_matricula());
			this.registrodao.save(editar);
		}

		//Para secretaria, certificado de promocion
		@Override
		public List<Registro> findByCedulaEstudiante(String cedula) {
					
			return registrodao.findByCedulaEstudiante(cedula);
		}


		@Override
		public List<Malla> ListMalla(Long empleado, Long id_periodo) {
			
			return malla.ListMalla(empleado, id_periodo);
		}


		@Override
		public List<Curso> ListCursosempelados(Long empleado, Long id_periodo, Long id_malla, Long id_modalidad) {
			
			return curso.ListCursosempelados(empleado, id_periodo, id_malla, id_modalidad);
		}


		@Override
		public List<Paralelo> ListParaleloempleados(Long empleado, Long id_periodo, Long id_malla, Long id_modalidad,
				Long id_curso) {
			
			return paralelo.ListParaleloempleados(empleado, id_periodo, id_malla, id_modalidad, id_curso);
		}


		@Override
		public List<Asignatura> ListAsignaturaempleados(Long empleado, Long id_periodo, Long id_malla,
				Long id_modalidad, Long id_curso, Long id_paralelo) {
			
			return asignatura.ListAsignaturaempleados(empleado, id_periodo, id_malla, id_modalidad, id_curso, id_paralelo);
		}


		@Override
		public List<Registro> filtrocompleto(Long id_periodo, Long id_malla, Long id_modalidad, Long id_curso,
				Long id_paralelo, Long id_asignatura) {
			
			return registrodao.filtrocompleto(id_periodo, id_malla, id_modalidad, id_curso, id_paralelo, id_asignatura);
		}


	
		



		
}
