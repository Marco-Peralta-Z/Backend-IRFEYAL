package com.irfeyal.controlador.rolseguridad;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.rolseguridad.Parroquia;
import com.irfeyal.servicio.rolseguridad.ParroquiaServices;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapParroquia")
public class ParroquiaControler {
	@Autowired
	private ParroquiaServices parroquiaSer;
	
	@GetMapping("/parroquia")
	public List<Parroquia> index(){
		return parroquiaSer.findAll();
	}
	
	
	@DeleteMapping("/parroquia/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			parroquiaSer.findById(id);
			parroquiaSer.deleteParroquia(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al eliminar la parroquia de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Parroquia eliminada con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
		
	@PostMapping("/parroquia")
	public ResponseEntity<?> create(@Validated @RequestBody Parroquia parroquia, BindingResult result) {
		
		
		Parroquia parroquiaNew= null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +"' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("erros", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		
		try {
			parroquiaNew= parroquiaSer.saveParroquia(parroquia);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje","La parroquia ha sido creado con exito");
		response.put("parroquia", parroquiaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/parroquia/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody Parroquia parroquia,BindingResult result, @PathVariable Long id) {
		Parroquia parroquiaActual = parroquiaSer.findById(id);
		Parroquia parroquiaUpdate= null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +"' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("erros", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		
		if (parroquiaActual == null) {
			response.put("mensaje", "Error: no se pudo editar, la parroquia ID: ".concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
			
		try {
			parroquiaActual.setParroquia(parroquia.getParroquia());
			parroquiaUpdate= parroquiaSer.saveParroquia(parroquiaActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al actualizar la parroquia en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","La parroquia ha sido actualizado con exito");
		response.put("parroquia", parroquiaUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}

}
