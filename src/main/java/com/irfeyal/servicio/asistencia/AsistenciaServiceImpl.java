package com.irfeyal.servicio.asistencia;
import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.irfeyal.modelo.dao.rolseguridad.PersonaDAO;
import com.irfeyal.modelo.matricula.Estudiante;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Paralelo;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;
import com.irfeyal.modelo.rolseguridad.Persona;
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
	public ResponseEntity<ByteArrayResource> exportInvoice(Long id_estudiante ,Long iddocente){
		Integer numfalta=0;
		List<Asistencia> asispedf= this.asistenciadao.obtenerIdEstudiante(id_estudiante,iddocente);
		
	    Estudiante estudiantedaoa=this.estudiantedao.findestudianteidpdf(id_estudiante);
			
			try {
			
				final File file = ResourceUtils.getFile("src/main/resources/PDF/reportesasistencias.jasper");
				final File imgLogo = ResourceUtils.getFile("src/main/resources/logo.png");
				final JasperReport report = (JasperReport) JRLoader.loadObject(file);
                 numfalta= asispedf.size();
				final Map<String, Object> parameters = new HashMap<>();
				parameters.put("id_estudiante", id_estudiante);
				parameters.put("persoNom", estudiantedaoa.getId_persona().getNombre());
				parameters.put("persoApe", estudiantedaoa.getId_persona().getApellido());
				parameters.put("cedula", estudiantedaoa.getId_persona().getCedula());
		        parameters.put("ds", new JRBeanCollectionDataSource((Collection<?>) this.clasedao.mostrarfechasidpdf(id_estudiante,iddocente)));
				parameters.put("imgLogo", new FileInputStream(imgLogo));
				parameters.put("numfalta", numfalta);
				
				
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





	

}
