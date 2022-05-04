package com.irfeyal.controlador.parametrizacionacademica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.interfaces.parametrizacionacademica.ParaleloServices;
import com.irfeyal.modelo.parametrizacionacademica.Paralelo;

@CrossOrigin(origins = "", maxAge = 3600)
@RestController
@RequestMapping("/paralelo")
public class ParaleloController {

	@Autowired
	private ParaleloServices paraleloService;

	@GetMapping(path = "", produces = "application/json")
	public ResponseEntity<?> getParalelos() {
		return new ResponseEntity<>(paraleloService.getAllParalelo(), HttpStatus.OK);
	}

	@GetMapping(path = "/", produces = "application/json")
	public ResponseEntity<?> getAllParalelos(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return new ResponseEntity<>(paraleloService.getAllParalelo(pageable), HttpStatus.OK);

	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<?> getParaleloById(@PathVariable("id") Long idParalelo) {
		Optional<Paralelo> paralelo = null;
		Map<String, Object> respuesta = new HashMap<>();
		try {
			paralelo = paraleloService.getParaleloById(idParalelo);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar la consulta en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (paralelo.isEmpty()) {
			respuesta.put("mensaje",
					"El Paralelo ID: ".concat(idParalelo.toString().concat(": no existe en la base de datos")));
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(paralelo, HttpStatus.OK);
	}

	@PostMapping(path = "", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> createParalelo(@Validated @RequestBody Paralelo paralelo,
			BindingResult result) {
		Paralelo paraleloNuevo = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			//Guardando paralelo
			paralelo.setDescripcion(paralelo.getDescripcion().toUpperCase());
			paraleloNuevo = paraleloService.saveParalelo(paralelo);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al crear el Paralelo en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("mensaje", "El Paralelo ha sido creado con éxito!");
		respuesta.put("paralelo", paraleloNuevo);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateParalelo(@PathVariable("id") Long idParalelo,@Validated @RequestBody Paralelo paralelo,
			BindingResult result) {
		Optional<Paralelo> paraleloActual = paraleloService.getParaleloById(idParalelo);
		Paralelo paraleloUpdated = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		if (paraleloActual.isEmpty()) {
			respuesta.put("mensaje", "Error: no se pudo editar el Paralelo: "
					.concat(idParalelo.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			//Actualizando paralelo
			paraleloActual.get().setDescripcion(paralelo.getDescripcion().toUpperCase());
			paraleloUpdated = paraleloService.saveParalelo(paraleloActual.get());
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar el update en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}

		respuesta.put("mensaje", "El Paralelo ha sido actualizado con éxito");
		respuesta.put("paralelo", paraleloUpdated);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Map<String, Object>> deleteParalelo(@PathVariable("id") Long idParalelo) {
		Map<String, Object> respuesta = new HashMap<>();
		try {
			Paralelo paraleloRecu = paraleloService.deleteParalelo(idParalelo);
			if (paraleloRecu == null) {
				respuesta.put("mensaje", "El Paralelo ID: " + idParalelo + " no existe en la base de datos");
				return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al eliminar el Paralelo de la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("mensaje", "El Paralelo ha sido eliminado");
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
	}
}
