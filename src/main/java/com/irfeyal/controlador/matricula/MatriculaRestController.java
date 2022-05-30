package com.irfeyal.controlador.matricula;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.matricula.Matricula;
import com.irfeyal.servicio.matricula.EnvioEmail;
import com.irfeyal.servicio.matricula.MatriculaServiceImpl;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/api")
public class MatriculaRestController {
	
	@Autowired
	private MatriculaServiceImpl matriculaService;
	
	@Autowired EnvioEmail sendEmail;
	
	
	@GetMapping("/matricula")
	public List<Matricula> index(){
		return matriculaService.findAll();
	}
	@GetMapping("/matricula/page/{page}")
	public Page<Matricula> index(@PathVariable Integer page){
		Pageable pageable= PageRequest.of(page, 3);
		return matriculaService.findAll(pageable);
	}
	
	@PostMapping("/matricula")
	public ResponseEntity<?> create(@Validated @RequestBody Matricula matricula, BindingResult result){
		
		Matricula matriculaNew= null;
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors= result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +" '" + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
			
		}
		
		try {
			matriculaNew= matriculaService.save(matricula);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		response.put("mensaje",	"Matricula creada con exito");
		response.put("estudiante", matriculaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/matricula/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody Matricula matricula, BindingResult result, @PathVariable Long id){
		Matricula matriculaActual= matriculaService.findById(id);
		Matricula matriculaUpdate= null;
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors= result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +" '" + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
			
		}
		
		if (matriculaActual==null) {
			response.put("mensaje", "Error: no se pudo editar, la matricula ID: ".concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			
			matriculaActual.setCurso(matricula.getCurso());
			matriculaActual.setFechaMatricula(matricula.getFechaMatricula());
			matriculaActual.setId_paralelo(matricula.getId_paralelo());
			matriculaActual.setId_periodo(matricula.getId_periodo());
			matriculaActual.setModalidad(matricula.getModalidad());
			matriculaActual.setUsuario(matricula.getUsuario());
			matriculaUpdate= matriculaService.save(matriculaActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		response.put("mensaje",	"Matricula actualizada con exito");
		response.put("estudiante", matriculaUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
		//	Metodo para enviar correo de notificacion de matricula aceptada al estudiante
	@PostMapping("/sendMail")
	public ResponseEntity<?> sendEmail(@Validated @RequestBody Matricula matricula) {
		Map<String, Object> response = new HashMap<>();
		String respuesta = sendEmail.sendEmailHtml(matricula);
		response.put("mensaje", respuesta);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
//	Metodos indirectos a tablas no pertenecientes al modulo matricula
	
//	@GetMapping("getJormadasPorCurso/{id_curso}")
//	public List<Modalidad> buscarByCurso(@PathVariable Long id_curso){
////		Modalidad modalidadExiste= null;
////		Map<String, Object> response = new HashMap<>();
////		
////		try {
////			modalidadExiste=matriculaService.findByCurso(id_curso);
////		} catch (DataAccessException e) {
////			response.put("mensaje", "Error no se pudo realizar la consulta");
////			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
////			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
////		}
////		if (modalidadExiste==null) {
////			response.put("mensaje", "Jornadas no existentes para curso con id: ".concat(id_curso.toString().concat(", no existe en la base de datos!")));
////			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
////		}
//		return matriculaService.findByCurso(id_curso);
//	}
	
}
