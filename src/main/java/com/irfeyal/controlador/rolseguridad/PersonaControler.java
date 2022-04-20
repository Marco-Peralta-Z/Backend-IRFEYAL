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
import com.irfeyal.modelo.rolseguridad.Persona;
import com.irfeyal.servicio.rolseguridad.PersonaServices;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapPersona")
public class PersonaControler {

	@Autowired
	private PersonaServices personaSer;
	
	@GetMapping("/persona")
	public List<Persona> index(){
		return personaSer.findAll();
	}
	
	
	@DeleteMapping("/persona/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			Persona personaNew =personaSer.findById(id);
			personaSer.deletePersona(id);	
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al eliminar la persona de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Persona eliminada con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	@PostMapping("/persona")
	public ResponseEntity<?> create(@Validated @RequestBody Persona persona, BindingResult result) {
		
		
		Persona personaNew= null;
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
			personaNew= personaSer.savePersona(personaNew);
		} catch (DataAccessException e) {                
			response.put("mensaje", "Erros al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje","El cliente ha sido creado con exito");
		response.put("cliente", personaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/persona/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody Persona persona,BindingResult result, @PathVariable Long id) {
		Persona personaactual = personaSer.findById(id);
		Persona personaUpdate= null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +"' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("erros", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		 
		if (personaactual == null) {
			response.put("mensaje", "Error: no se pudo editar, el cliente ID: ".concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		 
		try {
		
			personaactual.setApellido(persona.getApellido());
			personaactual.setCedula(persona.getCedula());
			personaactual.setFechaNacimiento(persona.getFechaNacimiento());
			personaactual.setGenero(persona.getGenero());
			personaactual.setNombre(persona.getNombre());
			personaUpdate= personaSer.savePersona(personaactual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al actualizar la persona en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","La persona ha sido actualizado con exito");
		response.put("persona", personaUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}


	
}
