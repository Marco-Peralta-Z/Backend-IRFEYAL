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
import com.irfeyal.modelo.rolseguridad.Provincia;
import com.irfeyal.servicio.rolseguridad.ProvinciaServices;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapProv")
public class ProvinciaControler {
		
	@Autowired
	 private ProvinciaServices provinciaSer;
	
	@GetMapping("/Provincia")
	public List<Provincia> index(){
		return provinciaSer.findAll();
	}
	
	
	@DeleteMapping("/provincia/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			provinciaSer.findById(id);
			provinciaSer.deleteProvincia(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al eliminar la provincia de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Provincia eliminada con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
		
	@PostMapping("/provincia")
	public ResponseEntity<?> create(@Validated @RequestBody Provincia provincia, BindingResult result) {
		
		
		Provincia provinciaNew= null;
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
			provinciaNew= provinciaSer.saveProvincia(provincia);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje","La Provincia ha sido creado con exito");
		response.put("provincia", provinciaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/provincia/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody Provincia provincia,BindingResult result, @PathVariable Long id) {
		Provincia provinciaActual = provinciaSer.findById(id);
		Provincia provinciaUpdate= null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +"' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("erros", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		
		if (provinciaActual == null) {
			response.put("mensaje", "Error: no se pudo editar, la provincia ID: ".concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
			
		try {
			provinciaActual.setProvincia(provincia.getProvincia());
			provinciaUpdate = provinciaSer.saveProvincia(provinciaActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al actualizar la provincia en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","La provincia ha sido actualizado con exito");
		response.put("provincia", provinciaUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
		
		

}
