package com.irfeyal.controlador.secretaria;

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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.interfaces.secretaria.IRegistroBitacoraService;
import com.irfeyal.modelo.secretaria.RegistroBitacora;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/api")
public class RegistroBitacoraController {

	@Autowired
	private IRegistroBitacoraService registroBitacoraService;
	
	//listar
	@GetMapping("/registroBitacora")
	public List<RegistroBitacora> index(){
		return registroBitacoraService.findAll();
	}
	
	@GetMapping("/registroBitacora/page/{page}")
	public Page<RegistroBitacora> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 3);
		
		return registroBitacoraService.findAll(pageable);
		
	}
	
	//Crear
	@PostMapping("/registroBitacora")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@Validated @RequestBody RegistroBitacora registroBitacora, BindingResult result){
		
		RegistroBitacora registroBitacoraNew= null;
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
			registroBitacoraNew= registroBitacoraService.save(registroBitacora);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		response.put("mensaje",	"El registro fue creado con exito");
		response.put("registroBitacora", registroBitacoraNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	//eliminar
	@DeleteMapping("/registroBitacora/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		registroBitacoraService.delete(id);
	}
	
	//editar
	@PutMapping("/registroBitacora/{id}")
	public ResponseEntity<?> show(@Validated @RequestBody RegistroBitacora registroBitacora, BindingResult result, @PathVariable Long id ) {
		RegistroBitacora registroActual=registroBitacoraService.findById(id);
		RegistroBitacora registroNew=null;
		
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors= result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +" '" + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
			
		}
		
		if (registroActual == null) {
			response.put("mensaje", "Error no se puedo editar el registro con el id".concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);	
		}
		
		try {
			registroActual.setEstado(registroBitacora.getEstado());
			registroNew = registroBitacoraService.save(registroActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
		response.put("mensaje", "Bitacora actualizada correctamente");
		response.put("registroBitacora", registroNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
}
