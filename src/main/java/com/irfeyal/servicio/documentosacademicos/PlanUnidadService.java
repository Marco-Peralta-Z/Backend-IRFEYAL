package com.irfeyal.servicio.documentosacademicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.irfeyal.interfaces.documentosacademicos.PlanUnidadInterface;
import com.irfeyal.modelo.dao.documentosacademicos.PlanUnidadDAO;
import com.irfeyal.modelo.dao.parametrizacionacademica.MallaRepository;
import com.irfeyal.modelo.dao.rolseguridad.UsuarioDAO;
import com.irfeyal.modelo.documentosacademicos.PlanUnidad;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.rolseguridad.Usuario;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class PlanUnidadService implements PlanUnidadInterface {
	
	@Autowired
	private PlanUnidadDAO planUnidadDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private MallaRepository mallaRepository;
	
	
	//Listar planes de unidad
	@Override
	public List<PlanUnidad> findAll() {
		return planUnidadDAO.findAll();
	}
	
    //Buscar usuario por id
	public Optional<Usuario> findUsuario (Long id){
		return usuarioDAO.findById(id);
	}
	
	//listar Planes de unidad por estado
	public List<PlanUnidad> findAllByEstado (String est){
		List<PlanUnidad> planunidadesRespuesta = new ArrayList<>();
		List<PlanUnidad> planunidades = planUnidadDAO.findAll();
		for (int i=0; i<planunidades.size(); i++) {
			if (planunidades.get(i).getEstado().equals(est)) {
				planunidadesRespuesta.add(planunidades.get(i));
			} 
		}
		return planunidadesRespuesta;
	}
	
	//listar Planes de unidad por Empleado y estado
		public List<PlanUnidad> findAllByEmpleado (Long id, String est){
			List<PlanUnidad> planunidadesRespuesta = new ArrayList<>();
			List<PlanUnidad> planunidades = planUnidadDAO.findAll();
			for (int i=0; i<planunidades.size(); i++) {
				if (planunidades.get(i).getEmpleado().getId_empleado() == id && planunidades.get(i).getEstado().equals(est)) {
					planunidadesRespuesta.add(planunidades.get(i));
				} 
			}
			return planunidadesRespuesta;
		}
		
		/*Buscar Plan de unidad por Unidad, asignatura, curso y modalidad 
		(Controlar la ceracion del Plan de Unidad con el mismo No de unidad)*/
		public boolean findPUByUnidadAsigCurso (Long id_unidad, Long id_asig, Long id_curso, Long id_paralelo, Long id_periodo, Long id_modalidad){
			List<PlanUnidad> planunidadesRespuesta = new ArrayList<>();
			List<PlanUnidad> planunidades = planUnidadDAO.findAll();
			boolean existe = false;
			for (int i=0; i<planunidades.size(); i++) {
				if ((planunidades.get(i).getUnidad().getIdUnidad() == id_unidad) &&
					(planunidades.get(i).getAsignatura().getId_asignatura() == id_asig) &&
					(planunidades.get(i).getCurso().getId_curso() == id_curso) &&
					(planunidades.get(i).getParalelo().getId_paralelo() == id_paralelo) &&
					(planunidades.get(i).getPeriodo().getId_periodo() == id_periodo) &&
					(planunidades.get(i).getModalidad().getId_modalidad() == id_modalidad)) {
					planunidadesRespuesta.add(planunidades.get(i));
				} 
			}
			if (planunidadesRespuesta.size() == 0) {
			    existe = false;
			} else {
				existe = true;
			}
			return existe; 
		}	
		
		//listar Cursos por Malla
		public List<Curso> findCursosByMalla (Long id){
			List<Curso> CursoRespuesta = new ArrayList<>();
			List<Curso> cursos = mallaRepository.findById(id).get().getListaCursos();
			for (int i=0; i<cursos.size(); i++) {
				CursoRespuesta.add(cursos.get(i));
			}
			return CursoRespuesta;
		}
	
//	//listar Asignaturas por Malla
//		public List<Asignatura> findAllByMalla (Long id){
//			List<Asignatura> AsigRespuesta = new ArrayList<>();
//			List<Asignatura> asignaturas = asignaturaRepository.findAll();
//			for (int i=0; i<asignaturas.size(); i++) {
//				long id_malla = asignaturas.get(i).getMallas().get(0).getId_malla();
//				if ( id_malla == id) {
//					AsigRespuesta.add(asignaturas.get(i));
//				}
//			}
//			return AsigRespuesta;
//		}
		
		//listar Asignaturas por Malla
		public List<Asignatura> findAsigByMalla (Long id){
			List<Asignatura> AsigRespuesta = new ArrayList<>();
			List<Asignatura> asignaturas = mallaRepository.findById(id).get().getListaAsignaturas();
			for (int i=0; i<asignaturas.size(); i++) {
					AsigRespuesta.add(asignaturas.get(i));
			}
			return AsigRespuesta;
		}
		
	//Update Plan de Unidad
	public  PlanUnidad  updatePlanUnidad ( Long  id , PlanUnidad  planUnidad ) {
		planUnidad.setId_plan_unidad(id);
	       return planUnidadDAO.save(planUnidad);
	}

	//Save Plan de unidad
	@Override
	public <S extends PlanUnidad> S save(S entity) {
		return planUnidadDAO.save(entity);
	}

	//Encontrar plan de unidad por Id
	@Override
	public Optional<PlanUnidad> findById(Long id) {
		return planUnidadDAO.findById(id);
	}

	//Delete plan de unidad
	@Override
	public void deleteById(Long id) {
		planUnidadDAO.deleteById(id);
	}
	
	private static final BaseColor color= new BaseColor(19, 63, 120 );
	private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLD,color);
	private static final Font subtFont = FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD,color);
	private static final Font bold = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD);
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	//Reporte del plan de unidad
	public FileOutputStream createPDFplanunidad(PlanUnidad datosPlanUnidad) {
		try {
			Document document = new Document(PageSize.A4);
			FileOutputStream ficheroPDF = new FileOutputStream("..\\..\\..\\Downloads\\PlanUnidadNo"+datosPlanUnidad.getUnidad().getIdUnidad()+"-"+
			datosPlanUnidad.getAsignatura().getDescripcion()+".pdf");
			PdfWriter.getInstance(document, ficheroPDF);
			
			document.open();
			String localDir = this.getClass().getClassLoader().getResource("logo.png").toString();
			Image logo= Image.getInstance(localDir);
			logo.scalePercent(17f);
			logo.setAlignment(Element.ALIGN_LEFT);
			Paragraph titulo= new Paragraph("PLAN DE UNIDAD", chapterFont);
			titulo.add(logo);
			titulo.setAlignment(1);
			document.add(titulo);
			
			//Encabezado
			Paragraph PAsignatura= new Paragraph();
			Chunk TitAsignatura= new Chunk("ASIGNATURA: ",bold);
			Chunk Asignatura= new Chunk(datosPlanUnidad.getAsignatura().getDescripcion());
			PAsignatura.add(TitAsignatura);
			PAsignatura.add(Asignatura);
			document.add(PAsignatura);
			
			Paragraph PDocente= new Paragraph();
			Chunk TitDocente= new Chunk("DOCENTE: ",bold);
			Chunk Docente= new Chunk((datosPlanUnidad.getEmpleado().getPersona().getNombre()+" "+datosPlanUnidad.getEmpleado().getPersona().getApellido()).toUpperCase());
			PDocente.add(TitDocente);
			PDocente.add(Docente);
			document.add(PDocente);
			
			Paragraph PPeriodo= new Paragraph();
			Chunk TitPeriodo= new Chunk("PERIODO: ",bold);
			Chunk Periodo= new Chunk(formatter.format(datosPlanUnidad.getPeriodo().getFecha_inicio())+" a "+ formatter.format(datosPlanUnidad.getPeriodo().getFecha_fin()).toUpperCase());
			PPeriodo.add(TitPeriodo);
			PPeriodo.add(Periodo);
			document.add(PPeriodo);
			
			Paragraph PMalla= new Paragraph();
			Chunk TitMalla= new Chunk("MALLA: ",bold);
			Chunk Malla= new Chunk(datosPlanUnidad.getPeriodo().getMalla().getDescripcion());
			PMalla.add(TitMalla);
			PMalla.add(Malla);
			document.add(PMalla);
			
			Paragraph PModalidad= new Paragraph();
			Chunk TitModalidad= new Chunk("MODALIDAD: ",bold);
			Chunk Modalidad= new Chunk(datosPlanUnidad.getModalidad().getDescripcion());
			PModalidad.add(TitModalidad);
			PModalidad.add(Modalidad);
			document.add(PModalidad);
			
			Paragraph PCurso= new Paragraph();
			Chunk TitCurso= new Chunk("CURSO: ",bold);
			Chunk Curso= new Chunk(datosPlanUnidad.getCurso().getDescripcion()+" - "+ datosPlanUnidad.getParalelo().getDescripcion());
			PCurso.add(TitCurso);
			PCurso.add(Curso);
			document.add(PCurso);
			
			Paragraph PFechasIniFin= new Paragraph();
			Chunk TitFechasIniFin= new Chunk("INICIO/FIN DE LA UNIDAD: ",bold);
			Chunk FechasIniFin= new Chunk(formatter.format(datosPlanUnidad.getFecha_inicio())+" - "+ formatter.format(datosPlanUnidad.getFecha_fin()).toUpperCase());
			PFechasIniFin.add(TitFechasIniFin);
			PFechasIniFin.add(FechasIniFin);
			document.add(PFechasIniFin);

			document.add(Chunk.NEWLINE);
			
			//Contenido
			Paragraph titulo2= new Paragraph("UNIDAD No "+datosPlanUnidad.getUnidad().getIdUnidad(), chapterFont);
			Paragraph tituloUnidad= new Paragraph(datosPlanUnidad.getTitulo_unidad(), subtFont);
			titulo2.setAlignment(1);
			tituloUnidad.setAlignment(1);
			document.add(titulo2);
			document.add(tituloUnidad);
			document.add(Chunk.NEWLINE);
			
			Paragraph TitObjetivos= new Paragraph("Objetivos especificos de la unidad.",bold);
			Paragraph Objetivos= new Paragraph(datosPlanUnidad.getObjetivos());
			Objetivos.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(TitObjetivos);
			document.add(Objetivos);
			document.add(Chunk.NEWLINE);
			
			Paragraph TitContenidos= new Paragraph("Contenidos de la unidad.",bold);
			Paragraph Contenidos= new Paragraph(datosPlanUnidad.getContenidos());
			Contenidos.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(TitContenidos);
			document.add(Contenidos);
			document.add(Chunk.NEWLINE);
			
			Paragraph TitCriterios= new Paragraph("Criterios de evaluacion.",bold);
			Paragraph Criterios= new Paragraph(datosPlanUnidad.getCriterios_evaluacion());
			Criterios.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(TitCriterios);
			document.add(Criterios);
			document.add(Chunk.NEWLINE);
			
			Paragraph TitDestrezas= new Paragraph("Destrezas con criterio de desempeño.",bold);
			Paragraph Destrezas= new Paragraph(datosPlanUnidad.getDestrezas());
			Destrezas.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(TitDestrezas);
			document.add(Destrezas);
			document.add(Chunk.NEWLINE);
			
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
