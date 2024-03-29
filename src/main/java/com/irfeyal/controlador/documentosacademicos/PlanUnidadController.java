package com.irfeyal.controlador.documentosacademicos;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.documentosacademicos.PlanUnidad;
import com.irfeyal.modelo.parametrizacionacademica.Area;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Curso;

import com.irfeyal.modelo.rolseguridad.Persona;
import com.irfeyal.modelo.rolseguridad.Usuario;
import com.irfeyal.servicio.documentosacademicos.PlanUnidadService;


import com.irfeyal.servicio.parametrizacionacademica.ModalidadServicesImp;
import com.irfeyal.servicio.parametrizacionacademica.ParaleloServicesImp;
import com.irfeyal.servicio.parametrizacionacademica.PeriodoServicesImp;
import com.itextpdf.text.Document;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping ("/planunidades/")
public class PlanUnidadController {
	
	@Autowired
	private PlanUnidadService planUnidadService;

	@Autowired
	private ModalidadServicesImp modalidadService;
	
	@Autowired
	private PeriodoServicesImp periodoService;
	
	
	@Autowired
	private ParaleloServicesImp paraleloService;

	
	@GetMapping
	private ResponseEntity<List<PlanUnidad>> getAllPlanUnidad (){
		return ResponseEntity.ok(planUnidadService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<PlanUnidad> savePlanUnidad (@RequestBody PlanUnidad planUnidad){
		
		try {
			PlanUnidad planUnidadGuardado = planUnidadService.save(planUnidad);
			return ResponseEntity.created(new URI("/planunidades/"+planUnidadGuardado.getId_plan_unidad())).body(planUnidadGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	@GetMapping ("usuario/{id_usuario}")
	private ResponseEntity<Optional<Usuario>> getUsuario (@PathVariable("id_usuario") Long id){
		return ResponseEntity.ok(planUnidadService.findUsuario(id));
	}
	
	@GetMapping ("{String}")
	private ResponseEntity<List<PlanUnidad>> getAllPlanunidadByEstado (@PathVariable("String") String est){
		return ResponseEntity.ok(planUnidadService.findAllByEstado(est));
	}
	
	@GetMapping ("{estado}/empleado/{id_empleado}")
	private ResponseEntity<List<PlanUnidad>> getAllPlanunidadByEmpleado (@PathVariable("id_empleado") Long id, @PathVariable("estado") String est){
		return ResponseEntity.ok(planUnidadService.findAllByEmpleado(id, est));
	}
	
	@PutMapping ("update/{id}")
	private ResponseEntity<PlanUnidad> updatePlanUnidad (@PathVariable ("id") Long id, @RequestBody PlanUnidad planUnidad){
		return ResponseEntity.ok(planUnidadService.updatePlanUnidad(id, planUnidad));
		
	}

	@DeleteMapping (value = "delete/{id}")
	private ResponseEntity<Boolean> deletePlanUnidad (@PathVariable ("id") Long id){
		planUnidadService.deleteById(id);
		return ResponseEntity.ok(!(planUnidadService.findById(id)!=null));
		
	}
	
	@GetMapping(path = "modalidades")
	public ResponseEntity<?> getAllModalidades() {
		return new ResponseEntity<>(modalidadService.getAllModalidad(), HttpStatus.OK);
	}
	
	@GetMapping(path = "periodos")
	public ResponseEntity<?> getAllPeriodos() {
		return new ResponseEntity<>(periodoService.getAllPeriodo(), HttpStatus.OK);
	}
	
	@GetMapping ("asignaturas/malla/{id_malla}")
	private ResponseEntity<List<Asignatura>> getAsigByMalla (@PathVariable("id_malla") Long id){
		return ResponseEntity.ok(planUnidadService.findAsigByMalla(id));
	}
	
	@GetMapping ("area/asignatura/{id_asignatura}")
	private ResponseEntity<Optional<Area>> getAreaByAsig (@PathVariable("id_asignatura") Long id){
		return ResponseEntity.ok(planUnidadService.findAreaByAsig(id));
	}
	
	@GetMapping ("cursos/malla/{id_malla}")
	private ResponseEntity<List<Curso>> getCursosByMalla (@PathVariable("id_malla") Long id){
		return ResponseEntity.ok(planUnidadService.findCursosByMalla(id));
	}
	
	@GetMapping(path = "paralelos")
	public ResponseEntity<?> getAllParalelos() {
		return new ResponseEntity<>(paraleloService.getAllParalelo(), HttpStatus.OK);
	}
	
	@GetMapping("paralelos/curso/{id_curso}/empleado/{id_empleado}")
	public ResponseEntity<?> getAllParalelosByCurso(@PathVariable("id_curso") Long id_curso, @PathVariable("id_empleado") Long id_empleado) {
		return new ResponseEntity<>(planUnidadService.findParalelosByCurso(id_curso, id_empleado), HttpStatus.OK);
	}
	
	@GetMapping ("{id_unidad}/{id_asignatura}/{id_curso}/{id_paralelo}/{id_periodo}/{id_modalidad}")
	private ResponseEntity<Boolean> verificarPlanUnidad (@PathVariable("id_unidad") Long id_unidad,
			@PathVariable("id_asignatura") Long id_asig, @PathVariable("id_curso") Long id_curso,
			@PathVariable("id_paralelo") Long id_paralelo, @PathVariable("id_periodo") Long id_periodo,
			@PathVariable("id_modalidad") Long id_modalidad){
		return ResponseEntity.ok(planUnidadService.findPUByUnidadAsigCurso(id_unidad, id_asig, id_curso,id_paralelo, id_periodo, id_modalidad));
	}
	
	@GetMapping ("cooracademico")
	private ResponseEntity<List<Persona>> getNomUsuariosByRolCoorAcademico (){
		return ResponseEntity.ok(planUnidadService.findUsuariosByRolCoorAcademico());
	}
	
	@PostMapping("pdfPlanUnidad/{coorpedagogico}")
	public ResponseEntity<?> createPDF(@Validated @RequestBody PlanUnidad planunidad, @PathVariable("coorpedagogico") String coorPedagogico) {
		return new ResponseEntity<>(planUnidadService.createPDFplanunidad(planunidad, coorPedagogico), HttpStatus.OK);
	}
	
}
