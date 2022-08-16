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
import com.irfeyal.modelo.rolseguridad.RolUsuario;
import com.irfeyal.servicio.rolseguridad.RolUsuarioServices;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping ("/mapRolUsuario")
public class RolUsuarioControler {
	@Autowired
	 private RolUsuarioServices rolusuarioSer;
	@GetMapping("/rolUsuario")
	public List<RolUsuario> index(){
		return rolusuarioSer.findAll();
	}
	
	
	@DeleteMapping("/rolUsuario/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			rolusuarioSer.findById(id);
			rolusuarioSer.deleteRolUsuario(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al eliminar el rol usuario de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Rol Usuario eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
		
	@PostMapping("/rolUsuario")
	public ResponseEntity<?> create(@Validated @RequestBody RolUsuario rolUsuario, BindingResult result) {
		
		
		RolUsuario rolUsuarioNew= null;
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
			rolUsuarioNew= rolusuarioSer.saveRolUsuario(rolUsuario);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje","El rol Usuario  ha sido creado con exito");
		response.put("rolUsuario", rolUsuarioNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/RolUsuario/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody RolUsuario rolUsuario,BindingResult result, @PathVariable Long id) {
		RolUsuario rolUsuarioActual = rolusuarioSer.findById(id);
		RolUsuario rolUsuarioUpdate= null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +"' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("erros", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		
		if (rolUsuarioActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el rolUsuario ID: ".concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
			
		try {
			rolUsuarioActual.setUsuario(rolUsuario.getUsuario());
			rolUsuarioActual.setEstado(rolUsuario.getEstado());
			rolUsuarioActual.setid_rol_usuario(rolUsuario.getid_rol_usuario());
			rolUsuarioActual.setRol(rolUsuario.getRol());
			rolUsuarioUpdate=rolusuarioSer.saveRolUsuario(rolUsuarioActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al actualizar el rol Usuario en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El rol Usuario ha sido actualizado con exito");
		response.put("rolUsuario", rolUsuarioUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}

		
}
