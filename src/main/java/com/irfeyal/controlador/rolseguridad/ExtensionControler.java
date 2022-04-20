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
import com.irfeyal.modelo.rolseguridad.Canton;
import com.irfeyal.modelo.rolseguridad.Extension;
import com.irfeyal.servicio.rolseguridad.ExtensionServices;





@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapExtension")
public class ExtensionControler {

	@Autowired
	 private ExtensionServices extensionSer;
	
	@GetMapping(path = { "/extension" }, produces = "application/json")
	public List<Extension> extension() {
		return extensionSer.findAll();
	}

	@DeleteMapping("/canton/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();

		try {
			Extension extensionNew = extensionSer.findById(id);
			extensionSer.deleteExtension(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al eliminar el cliente de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Canton eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}
		
	@PostMapping("/extension")
	public ResponseEntity<?> create(@Validated @RequestBody Extension extension, BindingResult result) {
		
		
		Extension extensionNew= null;
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
			extensionNew= extensionSer.saveExtension(extensionNew);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje","El cliente ha sido creado con exito");
		response.put("cliente", extensionNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/empresa/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody Extension extension,BindingResult result, @PathVariable Long id) {
		Extension extensionActual = extensionSer.findById(id);
		Extension extensionUpdate= null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +"' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("erros", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		
		if (extensionActual == null) {
			response.put("mensaje", "Error: no se pudo editar, la extension ID: ".concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
			
		try {
		
	
		extensionActual.setEmpresa(extension.getEmpresa());
		extensionActual.setnombre_extension(extension.getnombre_extension());
		extensionActual.setId_direccion(extension.getId_direccion());
		extensionActual.setId_extension(extension.getId_extension());
		extensionUpdate= extensionSer.saveExtension(extensionActual);
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al actualizarla extension en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","La extension ha sido actualizada con exito");
		response.put("extension", extensionUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}

	

	
}
