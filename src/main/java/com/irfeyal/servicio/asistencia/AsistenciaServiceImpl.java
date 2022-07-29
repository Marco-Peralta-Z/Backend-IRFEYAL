package com.irfeyal.servicio.asistencia;
import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.irfeyal.interfaces.asistencia.IAsistenciaService;
import com.irfeyal.modelo.asistencia.Asistencia;
import com.irfeyal.modelo.asistencia.Clase;
import com.irfeyal.modelo.dao.asistencia.IAsistenciaDao;
import com.irfeyal.modelo.dao.asistencia.IClaseDao;
import com.irfeyal.modelo.dao.matricula.IEstudianteDao;
import com.irfeyal.modelo.dao.parametrizacionacademica.AsignaturaRepository;
import com.irfeyal.modelo.dao.parametrizacionacademica.CursoRepository;
import com.irfeyal.modelo.dao.parametrizacionacademica.ModalidadRepository;
import com.irfeyal.modelo.dao.parametrizacionacademica.ParaleloRespository;
import com.irfeyal.modelo.dao.parametrizacionacademica.PeriodoRepository;
import com.irfeyal.modelo.dao.rolseguridad.EmpleadoDAO;
import com.irfeyal.modelo.dao.rolseguridad.PersonaDAO;
import com.irfeyal.modelo.dao.rolseguridad.RolUsuarioDAO;
import com.irfeyal.modelo.dao.rolseguridad.UsuarioDAO;
import com.irfeyal.modelo.matricula.Estudiante;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Paralelo;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;
import com.irfeyal.modelo.rolseguridad.Persona;
import com.irfeyal.modelo.rolseguridad.Rol;
import com.irfeyal.modelo.rolseguridad.RolUsuario;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.http.MediaType;
import java.util.Optional;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
@Service
public class AsistenciaServiceImpl implements IAsistenciaService{
	@Autowired
	private EmpleadoDAO empleado;
	@Autowired
	private RolUsuarioDAO usuarios;
	@Autowired
	private IAsistenciaDao asistenciadao;
	@Autowired
	private PersonaDAO personadao;
	@Autowired
	private IEstudianteDao estudiantedao;
	@Autowired
	private IClaseDao clasedao;
	
	@Autowired
	private ParaleloRespository paralelo;

	@Autowired
	private PeriodoRepository periodo;
	@Autowired
	private ModalidadRepository modalidad;
	@Autowired
	private AsignaturaRepository asignatura;
	
	private Long id_asistencia;
	@Autowired
	private CursoRepository curso;
	
	@Override
	public List<Asistencia> findAll() {
		// TODO Auto-generated method stub
		return (List<Asistencia>) asistenciadao.findAll();
	}

	@Override
	public Asistencia findById(Long id) {
		// TODO Auto-generated method stub
		return asistenciadao.findById(id).orElse(null);
	}

	@Override
	public Asistencia save(Asistencia asistencia) {
		// TODO Auto-generated method stub
		return asistenciadao.save(asistencia);
	}

	@Override
	public void delete(Long id) {
		asistenciadao.deleteById(id);
		
	}
	
	@Override
	public List <Persona> buscarcurso(Long id) {
			// TODO Auto-generated method stub
		return personadao.buscarcurso(id);
	}

	@Override
	public List<Estudiante> buscarcursomodalidad(Long id_mod, Long id_periodo, Long id_paralelo, Long id_asignatura ,Long id_curs) {
		
		
				return estudiantedao.buscarcursotodofil(id_mod, id_periodo, id_paralelo, id_asignatura, id_curs);
												
    }

	@Override
	public Estudiante buscarceduestudiante(String cedula) {
		
		return estudiantedao.buscarcedulaestudiante(cedula);
	}

	@Override
	public List<Modalidad> modalidaddocente(Integer id_docente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Asignatura> findAllAsignaturas() {
		// TODO Auto-generated method stub
		return asignatura.findAll();
	}

	@Override
	public List<Paralelo> findAllParalelo() {
		// TODO Auto-generated method stub
		return paralelo.findAll();
	}

	@Override
	public List<Modalidad> findAllModalidad() {
		// TODO Auto-generated method stub
		return modalidad.findAll();
	}

	@Override
	public List<Periodo> findAllperio() {
		// TODO Auto-generated method stub
		return periodo.findAll();
	}

	@Override
	public List<Curso> findAllcurso() {
		// TODO Auto-generated method stub
		return curso.findAll();
	}

	@Override

	public List<Asistencia> burcarasistencia(Long id_mod, Long id_periodo, Long id_paralelo, Long id_asignatura,
			Long id_curso, Date fecha, Long docente) {
		// TODO Auto-generated method stub
		return asistenciadao.actualizarfiltros(id_mod, id_periodo, id_paralelo, id_asignatura, id_curso, fecha,docente);
	}

	@Override
	public List<Estudiante> mostrarinformacion(long id) {
		// TODO Auto-generated method stub
		return estudiantedao.findestudianteid(id);
	}

	@Override
	public List<Periodo> listarpaeriodo(Long empleado) {
		// TODO Auto-generated method stub
		return periodo.listarperiodoasistencia(empleado);
	}

	@Override
	public List<Modalidad> listarmodalidad(Long emplead, Long idperiodo) {
		// TODO Auto-generated method stub
		return modalidad.listarmodalidadasistencia(emplead, idperiodo);
	}

	@Override
	public List<Curso> listarcurso(Long emplead, Long periodo, Long idmodalidad) {
		// TODO Auto-generated method stub
		return curso.listarcursoasistencia(emplead,periodo, idmodalidad);
	}

	@Override
	public List<Paralelo> listarparalelo(Long emple,Long periodo,Long modalidad, Long idcurso) {
		// TODO Auto-generated method stub
		return paralelo.listarparaleloasistencia(emple,periodo,modalidad, idcurso);
	}

	@Override
	public List<Asignatura> listarasignatura(Long empelado, Long idperiodo, Long modalidad, Long idcurso, Long idparalelo) {
		// TODO Auto-generated method stub
		return asignatura.listarasignaturaasistencia(empelado, idperiodo,modalidad, idcurso, idparalelo);
		
	}

	public List<Asistencia> actualizarfiltros(Long id_mod, Long id_periodo, Long id_paralelo, Long id_asignatura,
			Long id_curso, Date fecha,Long docente) {
		// TODO Auto-generated method stub
		return asistenciadao.actualizarfiltros(id_mod, id_periodo, id_paralelo, id_asignatura, id_curso, fecha,docente);
	}

	@NotNull
	public ResponseEntity<ByteArrayResource> exportInvoice(Long id_estudiante ,Long iddocente, Long idasignatura, Long usuario){
		Integer numfalta=0;
		Integer numfaltaAdmin=0;
		List<Asistencia> asispedf= this.asistenciadao.obtenerIdEstudiante(id_estudiante,iddocente,idasignatura);
		List<Asistencia> asispedfAdmin= this.asistenciadao.obtenerIdEstudianteAdmin(id_estudiante,idasignatura);
	    Estudiante estudiantedaoa=this.estudiantedao.findestudianteidpdf(id_estudiante);
			
			try {
			
				final File file = ResourceUtils.getFile("src/main/resources/PDF/reportesasistencias.jasper");
				final File imgLogo = ResourceUtils.getFile("src/main/resources/logo.png");
				final JasperReport report = (JasperReport) JRLoader.loadObject(file);
                 numfalta= asispedf.size();
                 numfaltaAdmin= asispedfAdmin.size();
				final Map<String, Object> parameters = new HashMap<>();
				parameters.put("id_estudiante", id_estudiante);
				parameters.put("tutor",empleado.findById(iddocente).get().getPersona().getNombre()+"  "+empleado.findById(iddocente).get().getPersona().getApellido());

				parameters.put("persoNom", estudiantedaoa.getId_persona().getNombre());
				parameters.put("persoApe", estudiantedaoa.getId_persona().getApellido());
				parameters.put("cedula", estudiantedaoa.getId_persona().getCedula());
				//validar si es administrador
				List<String>cargo= usuarios.validacionadmin(usuario);
				
				boolean validadmin=false;
				
				 for (int i=0;i<cargo.size();i++) {
					 
				if(cargo.get(i).equalsIgnoreCase("Administrador")) {
					
					validadmin=true;
					parameters.put("numfalta", numfaltaAdmin);
					 parameters.put("ds", new JRBeanCollectionDataSource((Collection<?>) this.clasedao.mostrarfechasidpdfadmin(id_estudiante,idasignatura)));
				}else{
					if(i==cargo.size()-1 && validadmin==false) {
						parameters.put("numfalta", numfalta);
				        parameters.put("ds", new JRBeanCollectionDataSource((Collection<?>) this.clasedao.mostrarfechasidpdf(id_estudiante,iddocente,idasignatura)));

					}

				}
				 }
				parameters.put("imgLogo", new FileInputStream(imgLogo));
				
				
				
				JasperPrint jPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
				byte [] reporte = JasperExportManager.exportReportToPdf(jPrint);
	                        
	                        String sdf = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date());
	                        
				StringBuilder stringBuilder = new StringBuilder().append("InvoicePDF:");
	                        org.springframework.http.ContentDisposition contentDisposition = org.springframework.http.ContentDisposition.builder("attachment")
	                                .filename(stringBuilder.append(id_estudiante)
	                                        .append("generateDate:")
	                                        .append(sdf)
	                                        .append(".pdf")
	                                        .toString())
	                                        .build();
				org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
	                        headers.setContentDisposition(contentDisposition);
	                        return ResponseEntity.ok().contentLength((long) reporte.length)
	                                .contentType(MediaType.APPLICATION_PDF)
	                                .headers(headers).body(new ByteArrayResource(reporte));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	        return null;
		
	}

	@Override
	public @NotNull ResponseEntity<ByteArrayResource> exportInvoicepdfcursos(Long id_mod, Long id_periodo,
			Long id_paralelo, Long id_asignatura, Long id_curso, Long docente, Long usuario) {
		
	
			
			try {
			
				final File file = ResourceUtils.getFile("src/main/resources/PDF/reportecursosasistencias.jasper");
				final File imgLogo = ResourceUtils.getFile("src/main/resources/logo.png");
				final JasperReport report = (JasperReport) JRLoader.loadObject(file);
                 
				final Map<String, Object> parameters = new HashMap<>();
				String periodocripcion=periodo.getById(id_periodo).getMalla().getDescripcion()+" "+periodo.getById(id_periodo).getAno_inicio()+"-"+periodo.getById(id_periodo).getAno_fin();
				parameters.put("desCurso", curso.getById(id_curso).getDescripcion());
				parameters.put("desParalelo", paralelo.getById(id_paralelo).getDescripcion());
				parameters.put("desPeriodo",periodocripcion);
				parameters.put("persoNom",empleado.findById(docente).get().getPersona().getNombre()+"  "+empleado.findById(docente).get().getPersona().getApellido());
				parameters.put("desModalidad", modalidad.getById(id_mod).getDescripcion());
List<String>cargos= usuarios.validacionadmin(usuario);
				
				boolean validadmincurso=false;
				 for (int i=0;i<cargos.size();i++) {
					 
						if(cargos.get(i).equalsIgnoreCase("Administrador")) {
							validadmincurso=true;
			        parameters.put("ds", new JRBeanCollectionDataSource((Collection<?>)	this.asistenciadao.sistenciapdftutor(id_mod, id_periodo, id_paralelo,  id_curso)));

				}else {
					if(i==cargos.size()-1 && validadmincurso==false) {
						 parameters.put("ds", new JRBeanCollectionDataSource((Collection<?>)	this.asistenciadao.sistenciapdf(id_mod, id_periodo, id_paralelo,  id_curso, docente)));
					}
					
			       

				}
				 }
				parameters.put("imgLogo", new FileInputStream(imgLogo));
				
				
				
				JasperPrint jPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
				byte [] reporte = JasperExportManager.exportReportToPdf(jPrint);
	                        
	                        String sdf = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date());
	                        
				StringBuilder stringBuilder = new StringBuilder().append("InvoicePDF:");
	                        org.springframework.http.ContentDisposition contentDisposition = org.springframework.http.ContentDisposition.builder("attachment")
	                                .filename(stringBuilder.append(id_asistencia)
	                                        .append("generateDate:")
	                                        .append(sdf)
	                                        .append(".pdf")
	                                        .toString())
	                                        .build();
				org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
	                        headers.setContentDisposition(contentDisposition);
	                        return ResponseEntity.ok().contentLength((long) reporte.length)
	                                .contentType(MediaType.APPLICATION_PDF)
	                                .headers(headers).body(new ByteArrayResource(reporte));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	        return null;
	}





	

}
