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
import com.irfeyal.servicio.rolseguridad.CantonService;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapCanton")


public class CantonControler {

	@Autowired
	private CantonService cantonSer;

	@GetMapping(path = { "/canton" })
	public List<Canton> canton() {
		return cantonSer.findAll();
	}
	
	
	@GetMapping(path = { "/canton/{id}" })
	public List<Canton> cantonporprovincia(@PathVariable Long id) {
		return cantonSer.findAllbyProvincia(id);
	}

	@DeleteMapping("/canton/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();

		try {
			cantonSer.findById(id);
			cantonSer.deleteCanton(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al eliminar el Cantón de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Cantón eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@PostMapping("/canton")
	public ResponseEntity<?> create(@Validated @RequestBody Canton canton, BindingResult result) {

		Canton cantonNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("erros", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			cantonNew = cantonSer.saveCanton(canton);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cantón ha sido creado con exito");
		response.put("canton", cantonNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/canton/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody Canton canton, BindingResult result, @PathVariable Long id) {
		Canton cantonActual = cantonSer.findById(id);
		Canton cantonUpdate = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("erros", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (cantonActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el cantón: "
					.concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			cantonActual.setCanton(canton.getCanton());
			cantonUpdate = cantonSer.saveCanton(cantonActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al actualizar el cantón en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El cantón ha sido actualizado con exito");
		response.put("canton", cantonUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}


		
}
