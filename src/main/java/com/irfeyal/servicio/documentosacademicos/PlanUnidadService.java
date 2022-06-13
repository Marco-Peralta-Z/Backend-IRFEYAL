package com.irfeyal.servicio.documentosacademicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.irfeyal.interfaces.documentosacademicos.PlanUnidadInterface;
import com.irfeyal.modelo.dao.documentosacademicos.PlanUnidadDAO;
import com.irfeyal.modelo.dao.parametrizacionacademica.AsignaturaRepository;
import com.irfeyal.modelo.dao.rolseguridad.UsuarioDAO;
import com.irfeyal.modelo.documentosacademicos.PlanUnidad;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
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
	private AsignaturaRepository asignaturaRepository;
	
	
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
		public boolean findPUByUnidadAsigCurso (Long id_u, Long id_a, Long id_c, Long id_m){
			List<PlanUnidad> planunidadesRespuesta = new ArrayList<>();
			List<PlanUnidad> planunidades = planUnidadDAO.findAll();
			boolean existe = false;
			for (int i=0; i<planunidades.size(); i++) {
				if ((planunidades.get(i).getUnidad().getIdUnidad() == id_u) &&
					(planunidades.get(i).getAsignatura().getId_asignatura() == id_a) &&
					(planunidades.get(i).getCurso().getId_curso() == id_c) &&
					(planunidades.get(i).getModalidad().getId_modalidad() == id_m)) {
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

			document.add(new Paragraph("ASIGNATURA: "+ datosPlanUnidad.getAsignatura().getDescripcion()));
			document.add(new Paragraph("DOCENTE: "+ (datosPlanUnidad.getEmpleado().getPersona().getNombre()+" "+datosPlanUnidad.getEmpleado().getPersona().getApellido()).toUpperCase()));
			document.add(new Paragraph("PERIODO: "+ formatter.format(datosPlanUnidad.getPeriodo().getFecha_inicio())+" a "+ formatter.format(datosPlanUnidad.getPeriodo().getFecha_fin()).toUpperCase()));
			document.add(new Paragraph("MALLA: "+ datosPlanUnidad.getPeriodo().getMalla().getDescripcion()));
			document.add(new Paragraph("MODALIDAD: "+ datosPlanUnidad.getModalidad().getDescripcion()));
			document.add(new Paragraph("CURSO: "+ datosPlanUnidad.getCurso().getDescripcion()+" - "));
			document.add(new Paragraph("INICIO/FIN DE LA UNIDAD: "+ formatter.format(datosPlanUnidad.getFecha_inicio())+" - "+ formatter.format(datosPlanUnidad.getFecha_fin()).toUpperCase()));
			document.add(Chunk.NEWLINE);
			
			Paragraph titulo2= new Paragraph("UNIDAD No "+datosPlanUnidad.getUnidad().getIdUnidad(), chapterFont);
			Paragraph tituloUnidad= new Paragraph(datosPlanUnidad.getTitulo_unidad(), subtFont);
			titulo2.setAlignment(1);
			tituloUnidad.setAlignment(1);
			document.add(titulo2);
			document.add(tituloUnidad);
			document.add(Chunk.NEWLINE);
			
			Paragraph parrafoObjetivos= new Paragraph();
			Chunk textObjetivos= new Chunk("Objetivos especificos de la unidad.",bold);
			Chunk Objetivos= new Chunk(datosPlanUnidad.getObjetivos());
			parrafoObjetivos.add(textObjetivos);
			parrafoObjetivos.add(Objetivos);
			parrafoObjetivos.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(parrafoObjetivos);
			document.add(Chunk.NEWLINE);
			
			Paragraph parrafoContenidos= new Paragraph();
			Chunk textContenidos= new Chunk("Contenidos de la unidad.",bold);
			Chunk Contenidos= new Chunk(datosPlanUnidad.getContenidos());
			parrafoContenidos.add(textContenidos);
			parrafoContenidos.add(Contenidos);
			parrafoContenidos.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(parrafoContenidos);
			document.add(Chunk.NEWLINE);
			
			Paragraph parrafoCriterios= new Paragraph();
			Chunk textCriterios= new Chunk("Criterios de evaluacion.",bold);
			Chunk Criterios= new Chunk(datosPlanUnidad.getCriterios_evaluacion());
			parrafoCriterios.add(textCriterios);
			parrafoCriterios.add(Criterios);
			parrafoCriterios.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(parrafoCriterios);
			document.add(Chunk.NEWLINE);
			
			Paragraph parrafoDestrezas= new Paragraph();
			Chunk textDestrezas= new Chunk("Destrezas con criterio de desempeño.",bold);
			Chunk Destrezas= new Chunk(datosPlanUnidad.getDestrezas());
			parrafoDestrezas.add(textDestrezas);
			parrafoDestrezas.add(Destrezas);
			parrafoDestrezas.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(parrafoDestrezas);
			document.add(Chunk.NEWLINE);
			
			document.close();
			System.out.println("------------------------------------CREADO PDF");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
