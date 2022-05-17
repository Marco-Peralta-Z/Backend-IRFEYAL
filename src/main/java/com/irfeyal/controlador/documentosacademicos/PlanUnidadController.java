package com.irfeyal.controlador.documentosacademicos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.documentosacademicos.PlanUnidad;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.servicio.documentosacademicos.PlanUnidadService;
import com.irfeyal.servicio.parametrizacionacademica.CursoServicesImp;
import com.irfeyal.servicio.parametrizacionacademica.EmpleadoServicesImp;
import com.irfeyal.servicio.parametrizacionacademica.ModalidadServicesImp;
import com.irfeyal.servicio.parametrizacionacademica.ParaleloServicesImp;
import com.irfeyal.servicio.parametrizacionacademica.PeriodoServicesImp;

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
	private CursoServicesImp cursosService;
	
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
	
	@GetMapping ("asignaturas/{id}")
	private ResponseEntity<List<Asignatura>> getAllAsignaturasByMalla (@PathVariable("id") Long id){
		try {
			return ResponseEntity.ok(planUnidadService.findAllByMalla(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	@GetMapping(path = "cursos")
	public ResponseEntity<?> getAllCursos() {
		return new ResponseEntity<>(cursosService.getAllCurso(), HttpStatus.OK);
	}
	
	@GetMapping(path = "paralelos")
	public ResponseEntity<?> getAllParalelos() {
		return new ResponseEntity<>(paraleloService.getAllParalelo(), HttpStatus.OK);
	}
	
}
