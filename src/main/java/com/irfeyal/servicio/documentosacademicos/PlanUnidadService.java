package com.irfeyal.servicio.documentosacademicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.irfeyal.interfaces.documentosacademicos.PlanUnidadInterface;
import com.irfeyal.modelo.dao.documentosacademicos.PlanUnidadDAO;
import com.irfeyal.modelo.dao.parametrizacionacademica.AreaRepository;
import com.irfeyal.modelo.dao.parametrizacionacademica.MallaRepository;
import com.irfeyal.modelo.dao.rolseguridad.RolUsuarioDAO;
import com.irfeyal.modelo.dao.rolseguridad.UsuarioDAO;
import com.irfeyal.modelo.documentosacademicos.PlanUnidad;
import com.irfeyal.modelo.parametrizacionacademica.Area;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.rolseguridad.Persona;
import com.irfeyal.modelo.rolseguridad.RolUsuario;
import com.irfeyal.modelo.rolseguridad.Usuario;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	
	@Autowired
	private AreaRepository areaRepository;
	
	@Autowired
	private RolUsuarioDAO rolUsuarioDAO;
	
	
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
		(Controlar la creacion del Plan de Unidad con el mismo No de unidad)*/
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
		
		//Buscar Area de asignatura
		public Optional<Area> findAreaByAsig (Long id_asig){
			//List<Area> AreaRespuesta = new ArrayList<>();
			//String AreaRespuesta = "";
			Optional<Area> AreaRespuesta = Optional.empty();
			boolean ban = false;
			List<Area> areas = areaRepository.findAll();
				for (long i=1; i<areas.size(); i++) {
					List<Asignatura> asignaturas = areaRepository.findById(i).get().getListaAsignaturas();
					for (int j=0; j<asignaturas.size(); j++) {
						if (asignaturas.get(j).getId_asignatura() == id_asig) {
							AreaRespuesta = Optional.of(areas.get((int) i));
							ban = true;
							break;
						}
					}
					if(ban==true) {
						break;
					}
				}
			return AreaRespuesta;
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
	
	//listar Nombres de Usuarios por Ror (Coordinador Pedagogico)
		public List<Persona> findUsuariosByRolCoorPedagogico (){
			List<Persona> personaRespuesta = new ArrayList<>();
			List<RolUsuario> rolUsuarios = (List<RolUsuario>) rolUsuarioDAO.findAll();
			for (int i=0; i<rolUsuarios.size(); i++) {
				if (rolUsuarios.get(i).getRol().getDescripcion().equals("Coordinador Pedagogico")) {
					personaRespuesta.add(rolUsuarios.get(i).getUsuario().getEmpleado().getPersona());
				} 
			}
			return personaRespuesta;
		}
	
	private static final BaseColor sombreado= new BaseColor(149, 179, 215);
	private static final Font fonttitulo2 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 11);
	private static final Font fonttitulo1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, Font.BOLD);
	private static final Font fontCabeceraTabla = FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, Font.BOLD);
	private static final Font fontDetalleTabla = FontFactory.getFont(FontFactory.HELVETICA, 9);
	private SimpleDateFormat formatter = new SimpleDateFormat("dd MMM, yyyy");
	private SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
	private Calendar calendar = Calendar.getInstance();
    private Date fechaActual = calendar.getTime();

	
	//Reporte del plan de unidad
	public FileOutputStream createPDFplanunidad(PlanUnidad datosPlanUnidad, String CoorPedagogico) {
		try {
			Document document = new Document(PageSize.A4.rotate());
			FileOutputStream ficheroPDF = new FileOutputStream("..\\..\\..\\Downloads\\PlanUnidadNo"+datosPlanUnidad.getUnidad().getIdUnidad()+"-"+
			datosPlanUnidad.getAsignatura().getDescripcion()+" "+datosPlanUnidad.getCurso().getDescripcion()+"-"+ datosPlanUnidad.getParalelo().getDescripcion()+" "+
			datosPlanUnidad.getModalidad().getDescripcion()+".pdf");
			PdfWriter.getInstance(document, ficheroPDF);
			
			document.open();
			//Tabla encabezado
			PdfPTable tablaEncabezado = new PdfPTable(3);
			//tablaEncabezado.setTotalWidth(500);
			tablaEncabezado.setWidthPercentage(102);
			float[] columnWidthsEncabezado = new float[]{25f, 60f, 17f};
			tablaEncabezado.setWidths(columnWidthsEncabezado);
			
			Chunk SaltoLinea= new Chunk(Chunk.NEWLINE);
			
			String localDir = this.getClass().getClassLoader().getResource("logo.png").toString();
			Image logo= Image.getInstance(localDir);
			logo.scalePercent(25f);
			logo.setAlignment(Element.ALIGN_CENTER);
			PdfPCell celdaLogo = new PdfPCell(logo);
			celdaLogo.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			Paragraph Titulo= new Paragraph();
			Chunk institucion = new Chunk("UNIDAD EDUCATIVA FISCOMISIONAL JOSÉ MARÍA VÉLAZ S.J.",fonttitulo1);
			Chunk extension = new Chunk("EXTENSIÓN No. 105 _ CUENCA",fonttitulo1);
			Chunk tituloDoc = new Chunk("PLAN MICROCURRICULAR POR MÓDULO",fonttitulo1);
			Chunk modalidad = new Chunk(("MODALIDAD "+datosPlanUnidad.getModalidad().getDescripcion()).toUpperCase(),fonttitulo1);
			Titulo.add(institucion);
			Titulo.add(SaltoLinea);
			Titulo.add(extension);
			Titulo.add(SaltoLinea);
			Titulo.add(tituloDoc);
			Titulo.add(SaltoLinea);
			Titulo.add(modalidad);
			PdfPCell celdaTitulo = new PdfPCell(new Phrase(Titulo));
			celdaTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			Paragraph AnoLectivo= new Paragraph();
			Chunk Alectivo = new Chunk("AÑO LECTIVO",fonttitulo2);
			Chunk DesAlectivo= new Chunk(datosPlanUnidad.getPeriodo().getAno_inicio()+" - "+datosPlanUnidad.getPeriodo().getAno_fin(),fonttitulo2);
			AnoLectivo.add(Alectivo);
			AnoLectivo.add(SaltoLinea);
			AnoLectivo.add(DesAlectivo);
			PdfPCell celdaALectivo = new PdfPCell(new Phrase(AnoLectivo));
			celdaALectivo.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			tablaEncabezado.addCell(celdaLogo);
			tablaEncabezado.addCell(celdaTitulo);
			tablaEncabezado.addCell(celdaALectivo);
			document.add(tablaEncabezado);
			
			//Tabla Datos Informativos
			Paragraph labelDatosInformativos= new Paragraph();
			Chunk labelDatosInfo= new Chunk("1. DATOS INFORMATIVOS:",fonttitulo1);
			labelDatosInformativos.add(Chunk.NEWLINE);
			labelDatosInformativos.add(labelDatosInfo);
			labelDatosInformativos.add(Chunk.NEWLINE);
			labelDatosInformativos.add(Chunk.NEWLINE);
			
			PdfPTable tablaDatoInfo1 = new PdfPTable(8);
			tablaDatoInfo1.setWidthPercentage(102);
			float[] columnWidthsInfo1 = new float[]{9f, 23f, 10f, 20f, 6f, 21f, 9f, 4f};
			tablaDatoInfo1.setWidths(columnWidthsInfo1);
			
			PdfPCell celdaLabelDocente = new PdfPCell(new Phrase("NOMBRE DE DOCENTE:", fontCabeceraTabla));
			celdaLabelDocente.setHorizontalAlignment(Element.ALIGN_LEFT);
			celdaLabelDocente.setBackgroundColor(sombreado);
			PdfPCell celdaDocente = new PdfPCell(new Phrase(datosPlanUnidad.getEmpleado().getPersona().getNombre()+" "+datosPlanUnidad.getEmpleado().getPersona().getApellido(), fontDetalleTabla));
			celdaDocente.setHorizontalAlignment(Element.ALIGN_LEFT);
			PdfPCell celdaLabelAreaAsig = new PdfPCell(new Phrase("AREA / ASIGNATURA:", fontCabeceraTabla));
			celdaLabelAreaAsig.setHorizontalAlignment(Element.ALIGN_LEFT);
			celdaLabelAreaAsig.setBackgroundColor(sombreado);
			PdfPCell celdaAreaAsignatura = new PdfPCell(new Phrase(findAreaByAsig(datosPlanUnidad.getAsignatura().getId_asignatura()).get().getDescripcion()+" / "+datosPlanUnidad.getAsignatura().getDescripcion(), fontDetalleTabla));
			celdaAreaAsignatura.setHorizontalAlignment(Element.ALIGN_LEFT);
			PdfPCell celdaLabelCurso = new PdfPCell(new Phrase("CURSO:", fontCabeceraTabla));
			celdaLabelCurso.setHorizontalAlignment(Element.ALIGN_LEFT);
			celdaLabelCurso.setBackgroundColor(sombreado);
			PdfPCell celdaCurso = new PdfPCell(new Phrase(datosPlanUnidad.getCurso().getDescripcion(), fontDetalleTabla));
			celdaCurso.setHorizontalAlignment(Element.ALIGN_LEFT);
			PdfPCell celdaLabelParalelo = new PdfPCell(new Phrase("PARALELO:", fontCabeceraTabla));
			celdaLabelParalelo.setHorizontalAlignment(Element.ALIGN_LEFT);
			celdaLabelParalelo.setBackgroundColor(sombreado);
			PdfPCell celdaParalelo = new PdfPCell(new Phrase(datosPlanUnidad.getParalelo().getDescripcion(), fontDetalleTabla));
			celdaParalelo.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPTable tablaDatoInfo2 = new PdfPTable(8);
			tablaDatoInfo2.setWidthPercentage(102);
			float[] columnWidthsInfo2 = new float[]{11f, 7f, 10f, 31f, 11f, 6f, 10f, 16f};
			tablaDatoInfo2.setWidths(columnWidthsInfo2);
			
			PdfPCell celdaLabelUnidad = new PdfPCell(new Phrase("N° DE UNIDAD:", fontCabeceraTabla));
			celdaLabelUnidad.setHorizontalAlignment(Element.ALIGN_LEFT);
			celdaLabelUnidad.setBackgroundColor(sombreado);
			PdfPCell celdaUnidad = new PdfPCell(new Phrase(""+datosPlanUnidad.getUnidad().getIdUnidad(), fontDetalleTabla));
			celdaUnidad.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell celdaLabelTituloUnidad = new PdfPCell(new Phrase("TITULO DE BLOQUE / MODULO:", fontCabeceraTabla));
			celdaLabelTituloUnidad.setHorizontalAlignment(Element.ALIGN_LEFT);
			celdaLabelTituloUnidad.setBackgroundColor(sombreado);
			PdfPCell celdaTituloUnidad = new PdfPCell(new Phrase(datosPlanUnidad.getTitulo_unidad(),fontDetalleTabla));
			celdaTituloUnidad.setHorizontalAlignment(Element.ALIGN_LEFT);
			PdfPCell celdaLabelNPeriodos = new PdfPCell(new Phrase("N° DE PERIODOS:", fontCabeceraTabla));
			celdaLabelNPeriodos.setHorizontalAlignment(Element.ALIGN_LEFT);
			celdaLabelNPeriodos.setBackgroundColor(sombreado);
			PdfPCell celdaNPeriodos = new PdfPCell(new Phrase(""+datosPlanUnidad.getNum_periodos(),fontDetalleTabla));
			celdaNPeriodos.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell celdaLabelSemanaIni = new PdfPCell(new Phrase("SEMANA DE INICIO:", fontCabeceraTabla));
			celdaLabelSemanaIni.setHorizontalAlignment(Element.ALIGN_LEFT);
			celdaLabelSemanaIni.setBackgroundColor(sombreado);
			PdfPCell celdaSemanaIni = new PdfPCell(new Phrase(formatter.format(datosPlanUnidad.getFecha_inicio())+" al "+formatter.format(datosPlanUnidad.getFecha_fin()),fontDetalleTabla));
			celdaSemanaIni.setHorizontalAlignment(Element.ALIGN_LEFT);
			
			PdfPTable tablaDatoInfo3 = new PdfPTable(2);
			tablaDatoInfo3.setWidthPercentage(102);
			float[] columnWidthsInfo3 = new float[]{22f, 80f};
			tablaDatoInfo3.setWidths(columnWidthsInfo3);
			
			PdfPCell celdaLabelObjetivos = new PdfPCell(new Phrase("OBJETIVOS ESPECÍFICOS:", fontCabeceraTabla));
			celdaLabelObjetivos.setHorizontalAlignment(Element.ALIGN_LEFT);
			celdaLabelObjetivos.setBackgroundColor(sombreado);
			PdfPCell celdaObjetivos = new PdfPCell(new Phrase(datosPlanUnidad.getObjetivos(), fontDetalleTabla));
			celdaObjetivos.setHorizontalAlignment(Element.ALIGN_LEFT);
			celdaObjetivos.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			PdfPCell celdaLabelCriterios = new PdfPCell(new Phrase("CRITERIOS DE EVALUACIÓN:", fontCabeceraTabla));
			celdaLabelCriterios.setHorizontalAlignment(Element.ALIGN_LEFT);
			celdaLabelCriterios.setBackgroundColor(sombreado);
			PdfPCell celdaCriterios = new PdfPCell(new Phrase(datosPlanUnidad.getCriterios_evaluacion(),fontDetalleTabla));
			celdaCriterios.setHorizontalAlignment(Element.ALIGN_LEFT);
			celdaCriterios.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			
			document.add(labelDatosInformativos);
			tablaDatoInfo1.addCell(celdaLabelDocente);
			tablaDatoInfo1.addCell(celdaDocente);
			tablaDatoInfo1.addCell(celdaLabelAreaAsig);
			tablaDatoInfo1.addCell(celdaAreaAsignatura);
			tablaDatoInfo1.addCell(celdaLabelCurso);
			tablaDatoInfo1.addCell(celdaCurso);
			tablaDatoInfo1.addCell(celdaLabelParalelo);
			tablaDatoInfo1.addCell(celdaParalelo);
			document.add(tablaDatoInfo1);
			tablaDatoInfo2.addCell(celdaLabelUnidad);
			tablaDatoInfo2.addCell(celdaUnidad);
			tablaDatoInfo2.addCell(celdaLabelTituloUnidad);
			tablaDatoInfo2.addCell(celdaTituloUnidad);
			tablaDatoInfo2.addCell(celdaLabelNPeriodos);
			tablaDatoInfo2.addCell(celdaNPeriodos);
			tablaDatoInfo2.addCell(celdaLabelSemanaIni);
			tablaDatoInfo2.addCell(celdaSemanaIni);
			document.add(tablaDatoInfo2);
			tablaDatoInfo3.addCell(celdaLabelObjetivos);
			tablaDatoInfo3.addCell(celdaObjetivos);
			tablaDatoInfo3.addCell(celdaLabelCriterios);
			tablaDatoInfo3.addCell(celdaCriterios);
			document.add(tablaDatoInfo3);


			Paragraph labelPlanificacion= new Paragraph();
			Chunk labelPlanif= new Chunk("2. PLANIFICACIÓN:",fonttitulo1);
			labelPlanificacion.add(Chunk.NEWLINE);
			labelPlanificacion.add(labelPlanif);
			labelPlanificacion.add(Chunk.NEWLINE);
			labelPlanificacion.add(Chunk.NEWLINE);
			
			//Tabla de Evaluacion sumativa, parte de tabla planificacion
			PdfPTable tablaPlanifEvaluacion = new PdfPTable(2);
			tablaPlanifEvaluacion.setWidthPercentage(100);
			float[] columnWidthsPlanifEvaluacion = new float[]{55f, 45f};
			tablaPlanifEvaluacion.setWidths(columnWidthsPlanifEvaluacion);
			
			PdfPCell celdaLabelEvaluacion = new PdfPCell(new Phrase("EVALUACIÓN SUMATIVA", fontCabeceraTabla));
			celdaLabelEvaluacion.setColspan(4);
			celdaLabelEvaluacion.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell celdaLabelIndicadores = new PdfPCell(new Phrase("INDICADORES PARA EVALUACIÓN DEL CRITERIO", fontCabeceraTabla));
			celdaLabelIndicadores.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell celdaLabelTecnicas = new PdfPCell(new Phrase("TÉCNICAS E INSTRUMENTOS", fontCabeceraTabla));
			celdaLabelTecnicas.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			tablaPlanifEvaluacion.addCell(celdaLabelEvaluacion);
			tablaPlanifEvaluacion.addCell(celdaLabelIndicadores);
			tablaPlanifEvaluacion.addCell(celdaLabelTecnicas);
			
			//Tabla planificacion
			PdfPTable tablaPlanificacion = new PdfPTable(4);
			tablaPlanificacion.setWidthPercentage(102);
			float[] columnWidthsPlanificacion = new float[]{28f, 30f, 12f, 32f};
			tablaPlanificacion.setWidths(columnWidthsPlanificacion);
			
			PdfPCell celdaLabelDestrezas = new PdfPCell(new Phrase("DESTREZAS CON CRITERIOS DE DESEMPEÑO", fontCabeceraTabla));
			celdaLabelDestrezas.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell celdaLabelActividades = new PdfPCell(new Phrase("ACTIVIDADES DE APRENDIZAJE", fontCabeceraTabla));
			celdaLabelActividades.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell celdaLabelRecursos = new PdfPCell(new Phrase("RECURSOS", fontCabeceraTabla));
			celdaLabelRecursos.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell celdaEvaluacionSumativa = new PdfPCell(tablaPlanifEvaluacion);
			celdaEvaluacionSumativa.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			document.add(labelPlanificacion);
			tablaPlanificacion.addCell(celdaLabelDestrezas);
			tablaPlanificacion.addCell(celdaLabelActividades);
			tablaPlanificacion.addCell(celdaLabelRecursos);
			tablaPlanificacion.addCell(celdaEvaluacionSumativa);
			document.add(tablaPlanificacion);
			
			//Tabla contenido de la planificacion
			PdfPTable tablaPlanificacion2 = new PdfPTable(5);
			tablaPlanificacion2.setWidthPercentage(102);
			float[] columnWidthsPlanificacion2 = new float[]{28f, 30f, 12f, 17.6f, 14.4f};
			tablaPlanificacion2.setWidths(columnWidthsPlanificacion2);
			
			PdfPCell celdaDestrezas = new PdfPCell(new Phrase(datosPlanUnidad.getDestrezas(), fontDetalleTabla));
			celdaDestrezas.setHorizontalAlignment(Element.ALIGN_LEFT);
			celdaDestrezas.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			Paragraph textActividades= new Paragraph();
			Chunk labelExperiencia= new Chunk("EXPERIENCIA.",fontCabeceraTabla);
			Chunk textExperiencia= new Chunk(datosPlanUnidad.getAct_experiencia(), fontDetalleTabla);
			Chunk labelReflexion= new Chunk("REFLEXIÓN.",fontCabeceraTabla);
			Chunk textReflexion= new Chunk(datosPlanUnidad.getAct_reflexion(), fontDetalleTabla);
			Chunk labelConcept= new Chunk("CONCEPTUALIZACIÓN.",fontCabeceraTabla);
			Chunk textConcept= new Chunk(datosPlanUnidad.getAct_conceptualizacion(), fontDetalleTabla);
			Chunk labelAplicacion= new Chunk("APLICACIÓN.",fontCabeceraTabla);
			Chunk textAplicacion= new Chunk(datosPlanUnidad.getAct_aplicacion(), fontDetalleTabla);
			textActividades.setAlignment(Element.ALIGN_JUSTIFIED);
			
			textActividades.add(labelExperiencia);
			textActividades.add(SaltoLinea);
			textActividades.add(textExperiencia);
			textActividades.add(Chunk.NEWLINE);
			textActividades.add(Chunk.NEWLINE);
			textActividades.add(labelReflexion);
			textActividades.add(SaltoLinea);
			textActividades.add(textReflexion);
			textActividades.add(Chunk.NEWLINE);
			textActividades.add(Chunk.NEWLINE);
			textActividades.add(labelConcept);
			textActividades.add(SaltoLinea);
			textActividades.add(textConcept);
			textActividades.add(Chunk.NEWLINE);
			textActividades.add(Chunk.NEWLINE);
			textActividades.add(labelAplicacion);
			textActividades.add(SaltoLinea);
			textActividades.add(textAplicacion);
			textActividades.add(Chunk.NEWLINE);
			textActividades.add(Chunk.NEWLINE);
			PdfPCell celdaActividades = new PdfPCell(new Phrase(textActividades));
			celdaActividades.setHorizontalAlignment(Element.ALIGN_LEFT);
			PdfPCell celdaRecursos = new PdfPCell(new Phrase(datosPlanUnidad.getRecursos(), fontDetalleTabla));
			celdaRecursos.setHorizontalAlignment(Element.ALIGN_LEFT);
			celdaRecursos.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			PdfPCell celdaIndicadores = new PdfPCell(new Phrase(datosPlanUnidad.getIndicadores(), fontDetalleTabla));
			celdaIndicadores.setHorizontalAlignment(Element.ALIGN_LEFT);
			celdaIndicadores.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			PdfPCell celdaTecnicas = new PdfPCell(new Phrase(datosPlanUnidad.getTecnicas(), fontDetalleTabla));
			celdaTecnicas.setHorizontalAlignment(Element.ALIGN_LEFT);
			celdaTecnicas.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			
			tablaPlanificacion2.addCell(celdaDestrezas);
			tablaPlanificacion2.addCell(celdaActividades);
			tablaPlanificacion2.addCell(celdaRecursos);
			tablaPlanificacion2.addCell(celdaIndicadores);
			tablaPlanificacion2.addCell(celdaTecnicas);
			document.add(tablaPlanificacion2);
			
			PdfPTable tablaPlanificacion3 = new PdfPTable(2);
			tablaPlanificacion3.setWidthPercentage(102);
			float[] columnWidthsPlanificacion3 = new float[]{51f, 51f};
			tablaPlanificacion3.setWidths(columnWidthsPlanificacion3);
			
			Paragraph textAdaptaciones= new Paragraph();
			Chunk labelAdaptaciones= new Chunk("ADAPTACIONES CURRICULARES: ",fontCabeceraTabla);
			Chunk NomAdaptaciones= new Chunk(datosPlanUnidad.getAdaptaciones_curriculares(), fontDetalleTabla);
			textAdaptaciones.add(labelAdaptaciones);
			textAdaptaciones.add(NomAdaptaciones);
			PdfPCell celdaAdaptaciones = new PdfPCell(new Phrase(textAdaptaciones));
			celdaAdaptaciones.setHorizontalAlignment(Element.ALIGN_LEFT);
			celdaAdaptaciones.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			celdaAdaptaciones.setColspan(4);
			PdfPCell celdaLabelAdaptacionesEducativa = new PdfPCell(new Phrase("ADAPTACIÓN DE LA NECESIDAD EDUCATIVA",fontCabeceraTabla));
			celdaLabelAdaptacionesEducativa.setHorizontalAlignment(Element.ALIGN_LEFT);
			celdaLabelAdaptacionesEducativa.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			celdaLabelAdaptacionesEducativa.setBackgroundColor(sombreado);
			PdfPCell celdaLabelEspecificacion = new PdfPCell(new Phrase("ESPECIFICACIÓN DE LA NECESIDAD A SER APLICADA",fontCabeceraTabla));
			celdaLabelEspecificacion.setHorizontalAlignment(Element.ALIGN_LEFT);
			celdaLabelEspecificacion.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			celdaLabelEspecificacion.setBackgroundColor(sombreado);
			PdfPCell celdaAdaptacionesEducativa = new PdfPCell(new Phrase(datosPlanUnidad.getAdap_necesidad_educativa(), fontDetalleTabla));
			celdaAdaptacionesEducativa.setHorizontalAlignment(Element.ALIGN_LEFT);
			celdaAdaptacionesEducativa.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			PdfPCell celdaEspecificacion = new PdfPCell(new Phrase(datosPlanUnidad.getEspecificacion_nesesidad(), fontDetalleTabla));
			celdaEspecificacion.setHorizontalAlignment(Element.ALIGN_LEFT);
			celdaEspecificacion.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			
			tablaPlanificacion3.addCell(celdaAdaptaciones);
			tablaPlanificacion3.addCell(celdaLabelAdaptacionesEducativa);
			tablaPlanificacion3.addCell(celdaLabelEspecificacion);
			tablaPlanificacion3.addCell(celdaAdaptacionesEducativa);
			tablaPlanificacion3.addCell(celdaEspecificacion);
			document.add(tablaPlanificacion3);
			
			//Tabla para las firmas
			PdfPTable tablaFirmas = new PdfPTable(3);

			//Fila encabezado
			PdfPCell textElaborado = new PdfPCell(new Phrase("ELABORADO POR: ", fontCabeceraTabla));
			textElaborado.setHorizontalAlignment(Element.ALIGN_CENTER);
			textElaborado.setBackgroundColor(sombreado);
			PdfPCell textRevisado = new PdfPCell(new Phrase("REVISADO", fontCabeceraTabla));
			textRevisado.setHorizontalAlignment(Element.ALIGN_CENTER);
			textRevisado.setBackgroundColor(sombreado);
			PdfPCell textAprobado = new PdfPCell(new Phrase("APROBADO", fontCabeceraTabla));
			textAprobado.setHorizontalAlignment(Element.ALIGN_CENTER);
			textAprobado.setBackgroundColor(sombreado);
			
			//Fila Nombres
			Paragraph textDocente= new Paragraph();
			Chunk labelDocente= new Chunk("DOCENTE: ",fontCabeceraTabla);
			Chunk NomDocente= new Chunk(datosPlanUnidad.getEmpleado().getPersona().getNombre()+" "+datosPlanUnidad.getEmpleado().getPersona().getApellido(), fontDetalleTabla);
			textDocente.add(labelDocente);
			textDocente.add(NomDocente);
			PdfPCell celdatextDocente = new PdfPCell(new Phrase(textDocente));
			celdatextDocente.setHorizontalAlignment(Element.ALIGN_LEFT);
			
			Paragraph textCoorA= new Paragraph();
			Chunk labelCoorA= new Chunk("COOR. DE ÁREA: ",fontCabeceraTabla);
			Chunk NomCoorA = new Chunk(datosPlanUnidad.getCoor_academico(), fontDetalleTabla);
			textCoorA.add(labelCoorA);
			textCoorA.add(NomCoorA);
			PdfPCell celdatextCoorA = new PdfPCell(new Phrase(textCoorA));
			celdatextCoorA.setHorizontalAlignment(Element.ALIGN_LEFT);
			
			Paragraph textCoorP= new Paragraph();
			Chunk labelCoorP= new Chunk("COOR. PEDAGÓGICO: ",fontCabeceraTabla);
			Chunk NomCoorP = new Chunk(CoorPedagogico, fontDetalleTabla);
			textCoorP.add(labelCoorP);
			textCoorP.add(NomCoorP);
			PdfPCell celdatextCoorP = new PdfPCell(new Phrase(textCoorP));
			celdatextCoorP.setHorizontalAlignment(Element.ALIGN_LEFT);
			
			//Fila firmas
			Paragraph textFirmaDocente= new Paragraph();
			textFirmaDocente.add(Chunk.NEWLINE);
			textFirmaDocente.add(Chunk.NEWLINE);
			Chunk labelFirmaDocente= new Chunk("FIRMA: ",fontCabeceraTabla);
			textFirmaDocente.add(labelFirmaDocente);
			PdfPCell celdafirmaDocente = new PdfPCell(new Phrase(textFirmaDocente));
			celdafirmaDocente.setHorizontalAlignment(Element.ALIGN_LEFT);
			Paragraph textFirmaCoorA= new Paragraph();
			textFirmaCoorA.add(Chunk.NEWLINE);
			textFirmaCoorA.add(Chunk.NEWLINE);
			Chunk labelFirmaCoorA= new Chunk("FIRMA: ",fontCabeceraTabla);
			textFirmaCoorA.add(labelFirmaCoorA);
			PdfPCell celdafirmaCoorA = new PdfPCell(new Phrase(textFirmaCoorA));
			celdafirmaCoorA.setHorizontalAlignment(Element.ALIGN_LEFT);
			Paragraph textFirmaCoorP= new Paragraph();
			textFirmaCoorP.add(Chunk.NEWLINE);
			textFirmaCoorP.add(Chunk.NEWLINE);
			Chunk labelFirmaCoorP= new Chunk("FIRMA: ",fontCabeceraTabla);
			textFirmaCoorP.add(labelFirmaCoorP);
			PdfPCell celdafirmaCoorP = new PdfPCell(new Phrase(textFirmaCoorP));
			celdafirmaCoorP.setHorizontalAlignment(Element.ALIGN_LEFT);
			
			//Fila fechas
			PdfPCell fechaCreacion = new PdfPCell(new Phrase("FECHA: "+formatter2.format(datosPlanUnidad.getFecha_creacion()), fontCabeceraTabla));
			fechaCreacion.setHorizontalAlignment(Element.ALIGN_LEFT);
			PdfPCell fechaRevision = new PdfPCell(new Phrase("FECHA: "+formatter2.format(datosPlanUnidad.getFecha_revision()), fontCabeceraTabla));
			fechaRevision.setHorizontalAlignment(Element.ALIGN_LEFT);
			PdfPCell fechaAprobacion = new PdfPCell(new Phrase("FECHA: "+formatter2.format(fechaActual), fontCabeceraTabla));
			fechaAprobacion.setHorizontalAlignment(Element.ALIGN_LEFT);
			
			tablaFirmas.addCell(textElaborado);
			tablaFirmas.addCell(textRevisado);
			tablaFirmas.addCell(textAprobado);
			tablaFirmas.addCell(celdatextDocente);
			tablaFirmas.addCell(celdatextCoorA);
			tablaFirmas.addCell(celdatextCoorP);
			tablaFirmas.addCell(celdafirmaDocente);
			tablaFirmas.addCell(celdafirmaCoorA);
			tablaFirmas.addCell(celdafirmaCoorP);
			tablaFirmas.addCell(fechaCreacion);
			tablaFirmas.addCell(fechaRevision);
			tablaFirmas.addCell(fechaAprobacion);
			tablaFirmas.setWidthPercentage(102);
			document.add(Chunk.NEWLINE);
			document.add(tablaFirmas);
			
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
