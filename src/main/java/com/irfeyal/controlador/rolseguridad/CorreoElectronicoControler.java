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
import com.irfeyal.modelo.rolseguridad.CorreoElectronico;
import com.irfeyal.servicio.rolseguridad.CorreoElectronicoServices;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapCorreoElectronico")


public class CorreoElectronicoControler {

	@Autowired
	 private CorreoElectronicoServices correoSer;
	
	@GetMapping ("/correo")
	
	public List<CorreoElectronico> correo(){
		return correoSer.findAll();
	}
	
	@DeleteMapping("/correo/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			correoSer.findById(id);
			correoSer.deleteCorreo(id);	
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al eliminar el correo de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Correo eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
		
	@PostMapping("/correo")
	public ResponseEntity<?> create(@Validated @RequestBody CorreoElectronico correo, BindingResult result) {
		
		
			CorreoElectronico correoNew= null;
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
			correoNew= correoSer.saveCorreo(correo);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje","El correo ha sido creado con exito");
		response.put("correo", correoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/canton/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody CorreoElectronico correo,BindingResult result, @PathVariable Long id) {
		CorreoElectronico correoActual = correoSer.findById(id);
		CorreoElectronico correoUpdate= null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +"' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("erros", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		
		if (correoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el correo ID: ".concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
			
		try {
		
			correoActual.setCorreo(correo.getCorreo());
			correoUpdate= correoSer.saveCorreo(correoActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el correo electronico en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El Correo ha sido actualizado con exito");
		response.put("correo", correoUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
	
}
