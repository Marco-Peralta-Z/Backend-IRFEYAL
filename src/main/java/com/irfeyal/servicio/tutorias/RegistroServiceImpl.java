package com.irfeyal.servicio.tutorias;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Collection;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import com.irfeyal.interfaces.tutorias.IRegistroService;
import com.irfeyal.modelo.dao.pagos.IComprobanteDao;
import com.irfeyal.modelo.dao.parametrizacionacademica.AsignaturaRepository;
import com.irfeyal.modelo.dao.parametrizacionacademica.CursoRepository;
import com.irfeyal.modelo.dao.parametrizacionacademica.MallaRepository;
import com.irfeyal.modelo.dao.parametrizacionacademica.ModalidadRepository;
import com.irfeyal.modelo.dao.parametrizacionacademica.ParaleloRespository;
import com.irfeyal.modelo.dao.parametrizacionacademica.PeriodoRepository;
import com.irfeyal.modelo.dao.tutorias.IRegistroDao;
import com.irfeyal.modelo.pagos.Comprobante;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Malla;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Paralelo;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;
import com.irfeyal.modelo.tutorias.Registro;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class RegistroServiceImpl implements IRegistroService {

	@Autowired
	private ParaleloRespository paralelodao;

	@Autowired
	private CursoRepository cursodao;

	@Autowired
	private AsignaturaRepository asignaturadao;

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
	private IComprobanteDao comprobante;

	private Long id_registro;

	public Registro save(Registro registro) {
		return registrodao.save(registro);
	}

	// buscar por id
	@Override
	// @Transactional(readOnly = true)
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

		return (List<Registro>) registrodao.findAll();
	}

	@Override
	public Comprobante buscarceduestudiante(String cedula) {

		return comprobante.buscarcedulaestudiante(cedula);
	}

	@Override
	public Registro cargardatos(Long matricula) {

		Registro registro = new Registro();
		registro.setAporte1(0);
		registro.setAporte2(0);
		registro.setExamen_Iquimestre(0);
		registro.setPromedio_Iquimestre(0);
		registro.setAporte3(0);
		registro.setAporte4(0);
		registro.setExamen_IIquimestre(0);
		registro.setPromedio_IIquimestre(0);
		registro.setConducta(0);
		registro.setNota_final(0);
		registro.setExamen_supletorio(0);
		registro.setExamen_remedial(0);
		registro.setExamen_gracia(0);
		registro.setEstado("Reprobado");

		return registrodao.save(registro);
	}

	@Override
	public void update(Registro registro, Long id_registro) {
		Optional<Registro> editReporte = this.registrodao.findById(id_registro);
		Registro editar = editReporte.get();
		editar.setId_registro(registro.getId_registro());
		editar.setAporte1(registro.getAporte1());
		editar.setAporte2(registro.getAporte2());
		editar.setExamen_Iquimestre(registro.getExamen_Iquimestre());
		editar.setPromedio_Iquimestre(registro.getPromedio_Iquimestre());
		editar.setConducta(registro.getConducta());
		editar.setNota_final(registro.getNota_final());
		editar.setAporte3(registro.getAporte3());
		editar.setAporte4(registro.getAporte4());
		editar.setExamen_IIquimestre(registro.getExamen_IIquimestre());
		editar.setPromedio_IIquimestre(registro.getPromedio_IIquimestre());
		editar.setExamen_supletorio(registro.getExamen_supletorio());
		editar.setExamen_remedial(registro.getExamen_remedial());
		editar.setExamen_gracia(registro.getExamen_gracia());
		editar.setEstado(registro.getEstado());
		this.registrodao.save(editar);
	}

	// Para secretaria, certificado de promocion
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
	public List<Asignatura> ListAsignaturaempleados(Long empleado, Long id_periodo, Long id_malla, Long id_modalidad,
			Long id_curso, Long id_paralelo) {

		return asignatura.ListAsignaturaempleados(empleado, id_periodo, id_malla, id_modalidad, id_curso, id_paralelo);
	}

	@Override
	public List<Registro> filtrocompleto(Long id_empleado, Long id_periodo, Long id_malla, Long id_modalidad,
			Long id_curso, Long id_paralelo, Long id_asignatura) {
		return registrodao.filtrocompleto(id_empleado, id_periodo, id_malla, id_modalidad, id_curso, id_paralelo,
				id_asignatura);
	}

	@NotNull
	public ResponseEntity<ByteArrayResource> exportInvoice(Long id_empleado, Long id_periodo, Long id_malla,
			Long id_modalidad, Long id_curso, Long id_paralelo, Long id_asignatura) {

		try {
			final File file = ResourceUtils.getFile("src/main/resources/PDF/reporteTutorias.jasper");
			final File logo = ResourceUtils.getFile("src/main/resources/logo.png");
			final JasperReport report = (JasperReport) JRLoader.loadObject(file);

			final Map<String, Object> parameters = new HashMap<>();
			parameters.put("ds",
					new JRBeanCollectionDataSource((Collection<?>) this.registrodao.filtrocompleto(id_empleado,
							id_periodo, id_malla, id_modalidad, id_curso, id_paralelo, id_asignatura)));
			parameters.put("logoIrfeyal", new FileInputStream(logo));
			parameters.put("desCurso", cursodao.getById(id_curso).getDescripcion());
			parameters.put("desParalelo", paralelodao.getById(id_paralelo).getDescripcion());
			parameters.put("desAsignatura", asignaturadao.getById(id_asignatura).getDescripcion());
			JasperPrint jPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
			byte[] reporte = JasperExportManager.exportReportToPdf(jPrint);

			String sdf = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date());
			StringBuilder stringBuilder = new StringBuilder().append("InvoicePDF:");
			org.springframework.http.ContentDisposition contentDisposition = org.springframework.http.ContentDisposition
					.builder("attachment").filename(stringBuilder.append(id_registro).append("generateDate:")
							.append(sdf).append(".pdf").toString())
					.build();
			org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
			headers.setContentDisposition(contentDisposition);
			return ResponseEntity.ok().contentLength((long) reporte.length).contentType(MediaType.APPLICATION_PDF)
					.headers(headers).body(new ByteArrayResource(reporte));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Registro> getAllRegistrosByMatriculaId(Long id) {
		return registrodao.getAllRegistrosByMatriculaId(id);
	}

	@Override
	public List<Registro> getAllRegistrosByCursoModalidadPeridod(Long idCurso, Long idModalidad, Long idPeridod) {
		return registrodao.getAllRegistrosByCursoModalidadPeridod(idCurso, idModalidad, idPeridod);
	}

}
