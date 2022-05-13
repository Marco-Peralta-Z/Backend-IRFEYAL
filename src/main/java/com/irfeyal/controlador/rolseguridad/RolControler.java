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
import com.irfeyal.modelo.rolseguridad.Rol;
import com.irfeyal.servicio.rolseguridad.RolServices;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapRol")
public class RolControler {

	@Autowired
	 private RolServices rolSer;
	
	@GetMapping("/rol")
	public List<Rol> index(){
		return rolSer.findAll();
	}
	
	
	@DeleteMapping("/rol/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			rolSer.findById(id);
			rolSer.deleteRol(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al eliminar el rol de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Rol eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
		
	@PostMapping("/rol")
	public ResponseEntity<?> create(@Validated @RequestBody Rol rol, BindingResult result) {
		
		
		Rol rolNew= null;
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
			rolNew= rolSer.saveRol(rol);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje","El rol ha sido creado con exito");
		response.put("rol", rolNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/rol/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody Rol rol,BindingResult result, @PathVariable Long id) {
		Rol rolActual = rolSer.findById(id);
		Rol rolUpdate= null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +"' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("erros", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		
		if (rolActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el rol ID: ".concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
			
		try {
		
		rolActual.setDescripcion(rol.getDescripcion());
		rolUpdate = rolSer.saveRol(rolActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al actualizar el rol en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El Rol ha sido actualizado con exito");
		response.put("rol", rolUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
		
}
