package com.irfeyal.controlador.asistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.irfeyal.interfaces.asistencia.IAsistenciaService;
import com.irfeyal.interfaces.asistencia.IClaseService;
import com.irfeyal.modelo.asistencia.Asistencia;
import com.irfeyal.modelo.asistencia.Clase;
import com.irfeyal.modelo.matricula.Estudiante;
import com.irfeyal.modelo.rolseguridad.Persona;


@RestController
@RequestMapping("/asistencia")
@CrossOrigin(origins = "*")
public class AsistenciaController {

	@Autowired
	private IAsistenciaService asistenciaservice;
	
	@Autowired
	private IClaseService claseservice;
	
	
	@GetMapping("/listarasistencia")
	public List<Asistencia> index() {
		return asistenciaservice.findAll();

    }
	
	@PostMapping("/asistenciasave")
	public ResponseEntity<Asistencia> save(@RequestBody Asistencia asistencia){
		Asistencia obj=asistenciaservice.save(asistencia);
		
		return new ResponseEntity<Asistencia>(obj,HttpStatus.OK);
	}
	
	@PostMapping("/clasesave")
	public ResponseEntity<Clase> save(@RequestBody Clase clase){
		Clase obj=claseservice.save(clase);
		
		return new ResponseEntity<Clase>(obj,HttpStatus.OK);
	}
	
	@GetMapping("/listarclase")
	public List<Clase> findAll() {
		return claseservice.findAll();
	}
	
	
	@GetMapping("/asistenciadelete/{id}")
	public ResponseEntity<Asistencia> delete(@PathVariable Long id){
		Asistencia asistencia=asistenciaservice.findById(id);
		if(asistencia!=null) {
		asistenciaservice.delete(id);
		}else {
			return new ResponseEntity<Asistencia>(asistencia,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Asistencia>(asistencia,HttpStatus.OK);
		
	}
	
	@GetMapping("/buscarestudiantesdeuncurso/{id}")
	public  List<Persona> buscarcurso(@PathVariable Long id){
		
		return asistenciaservice.buscarcurso(id);
		
		
	}
	
	@GetMapping("/filtrosdelaasistencia/{idmod}/{idper}/{idpar}/{idasig}")
	public List<Estudiante> filtros(@PathVariable Long idmod,@PathVariable Long idper,@PathVariable Long idpar,@PathVariable Long idasig ){
		
		
		return asistenciaservice.buscarcursomodalidad(idmod, idper, idpar, idasig);
		
	}
	
	@GetMapping("/mostrarfechasdefaltas/{ides}/{iddo}")
	public List<Clase> fechas(@PathVariable Long ides,@PathVariable Integer iddo ){
		
		
		return claseservice.mostrarfechas(ides, iddo);
		
	}
	
	@GetMapping("/buscarestudianteporcedula/{ced}")
	public Estudiante fecha(@PathVariable String ced ){
		
		
		return asistenciaservice.buscarceduestudiante(ced);
		
	}
	
}
