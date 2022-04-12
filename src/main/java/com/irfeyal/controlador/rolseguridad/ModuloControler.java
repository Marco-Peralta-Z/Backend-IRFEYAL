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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.rolseguridad.Modulo;
import com.irfeyal.servicio.rolseguridad.ModuloInterface;



@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapModulo")

public class ModuloControler {
	@Autowired
	 private ModuloInterface moduloSer;
	
	@GetMapping ("/modulo")
	
	public List<Modulo> modulo(){
	 return moduloSer.findAll();
	}
	public List<Modulo> modulodel(){
		 return moduloSer.deleteModulo(null);
		}
		
	@PostMapping("/modulo")
	public ResponseEntity<?> create(@Validated @RequestBody Modulo modulo, BindingResult result) {
		
		
		Modulo moduloNew= null;
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
			moduloNew= moduloSer.saveModulo(moduloNew);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje","El modulo ha sido creado con exito");
		response.put("cliente", moduloNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/modulo/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody Modulo modulo,BindingResult result, @PathVariable Long id) {
		Modulo moduloActual = moduloSer.findById(id);
		Modulo moduloUpdate= null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +"' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("erros", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		
		if (moduloActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el modulo ID: ".concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
			
		try {
		moduloActual.setIdModulo(modulo.getIdModulo());
		moduloActual.setModulo(modulo.getModulo());
		moduloActual.setUrl(modulo.getUrl());
		moduloActual.setId_rol_usuario(modulo.getId_rol_usuario());
		moduloUpdate= moduloSer.saveModulo(moduloActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al actualizar el modulo en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El Modulo ha sido actualizado con exito");
		response.put("modulo", moduloUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
		
	
}
