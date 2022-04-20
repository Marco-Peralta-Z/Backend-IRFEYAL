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
import com.irfeyal.modelo.rolseguridad.Direccion;
import com.irfeyal.servicio.rolseguridad.DireccionServices;




@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapDireccion")
public class DireccionControler {
	
	@Autowired
	 private DireccionServices direccionSer;
	@GetMapping("/direccion")
	public List<Direccion> index(){
		return direccionSer.findAll();
	}
	
	
	@DeleteMapping("/direccion/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			Direccion direccionNew =direccionSer.findById(id);
			direccionSer.deleteDireccion(id);	
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al eliminar la direccion de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Direccion eliminada con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	@PostMapping("/direccion")
	public ResponseEntity<?> create(@Validated @RequestBody Direccion direccion, BindingResult result) {
		
		
		Direccion direccionNew= null;
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
			direccionNew= direccionSer.saveDireccion(direccionNew);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje","La Direccion ha sido creado con exito");
		response.put("direccion", direccionNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/direccion/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody Direccion direccion,BindingResult result, @PathVariable Long id) {
		Direccion direccionActual = direccionSer.findById(id);
		Direccion  direccionUpdate= null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +"' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("erros", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		
		if (direccionActual == null) {
			response.put("mensaje", "Error: no se pudo editar, la direccion ID: ".concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
			
		try {
		
			direccionActual.setAvPrincipal(direccion.getAvPrincipal());
			direccionActual.setAvSecundaria(direccion.getAvSecundaria());
			direccionActual.setCanton(direccion.getCanton());
			direccionActual.setPais(direccion.getPais());
			direccionActual.setParroquia(direccion.getParroquia());
			direccionActual.setProvincia(direccion.getProvincia());
			direccionUpdate= direccionSer.saveDireccion(direccionActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al actualizar el cliente en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","La direccion ha sido actualizado con exito");
		response.put("direccion", direccionUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
}
