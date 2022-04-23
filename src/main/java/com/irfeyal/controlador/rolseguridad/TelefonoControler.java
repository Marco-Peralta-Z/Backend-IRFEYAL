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

import com.irfeyal.interfaces.rolseguridad.TelefonoInterface;
import com.irfeyal.modelo.rolseguridad.Telefono;
import com.irfeyal.servicio.rolseguridad.TelefonoServices;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapTelefono")
public class TelefonoControler {
	@Autowired
	 private TelefonoServices telefonoSer;
	
	@GetMapping("/Telefono")
	public List<Telefono> index(){
		return telefonoSer.findAll();
	}
	
	
	@DeleteMapping("/telefono/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			Telefono telefonoNew =telefonoSer.findById(id);
			telefonoSer.deleteTelefono(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al eliminar el telefono de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Telefono eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
		
	@PostMapping("/telefono")
	public ResponseEntity<?> create(@Validated @RequestBody Telefono telefono, BindingResult result) {
		
		
		Telefono telefonoNew= null;
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
			telefonoNew= telefonoSer.saveTelefono(telefonoNew);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje","El telefono ha sido creado con exito");
		response.put("Telefono", telefonoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/telefono/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody Telefono telefono,BindingResult result, @PathVariable Long id) {
		Telefono telefonoActual = telefonoSer.findById(id);
		Telefono telefonoUpdate= null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +"' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("erros", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		
		if (telefonoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el telefono ID: ".concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
			
		try {
		telefonoActual.setTelefono(telefono.getTelefono());
		telefonoActual.setNumCelular(telefono.getNumCelular());
		telefonoActual.setExtension(telefono.getExtension());
		telefonoUpdate= telefonoSer.saveTelefono(telefonoActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al actualizar el telefono en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El Telefono ha sido actualizado con exito");
		response.put("telefono", telefonoUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	

	
}
