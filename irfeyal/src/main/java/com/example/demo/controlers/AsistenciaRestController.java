package com.example.demo.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Asignatura;
import com.example.demo.models.entity.Asistencia;
import com.example.demo.service.IAsistenciaService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class AsistenciaRestController {

	@Autowired
	private IAsistenciaService asistenciaservice;
	
	@GetMapping("/asistencia")
	public List<Asistencia> index() {
		return asistenciaservice.findAll();

}
	
	@GetMapping("/asistencia/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Asistencia asistencia=asistenciaservice.findById(id);
		Map <String, Object> response =new HashMap<>();
		try {
			asistencia=asistenciaservice.findById(id);
		} catch (Exception e) {
		response.put("mensaje", "Error al realizar consulta");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		if(asistencia==null) {
			response.put("mensaje", "El id de la asistencia ".concat(id.toString().concat("no existe")));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<Asistencia>(asistencia,HttpStatus.OK);
	}
	
	
	
	@PostMapping("/asistencia")
	@ResponseStatus(HttpStatus.CREATED)
public ResponseEntity<?> create(@Validated @RequestBody Asistencia asistencia, BindingResult result) {
		
		Asistencia asistenciaNew = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			asistenciaNew = asistenciaservice.save(asistencia);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "la asistencia ha sido creado con éxito!");
		response.put("cliente", asistenciaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	



}
