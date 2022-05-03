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

import com.irfeyal.interfaces.parametrizacionacademica.AsignaturaServices;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;

@CrossOrigin(origins = "", maxAge = 3600)
@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {

	@Autowired
	private AsignaturaServices asignaturaService;

	@GetMapping(path = "", produces = "application/json")
	public ResponseEntity<?> getAsignaturas() {
		return new ResponseEntity<>(asignaturaService.getAllAsignatura(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/", produces = "application/json")
	public ResponseEntity<?> getAllAsignaturas(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return new ResponseEntity<>(asignaturaService.getAllAsignatura(pageable), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<?> getAsignaturaById(@PathVariable("id") Long idAsignatura) {
		Optional<Asignatura> asignatura = null;
		Map<String, Object> respuesta = new HashMap<>();
		try {
			asignatura = asignaturaService.getAsignaturaById(idAsignatura);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar la consulta en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (asignatura.isEmpty()) {
			respuesta.put("mensaje",
					"La Asignatura ID: ".concat(idAsignatura.toString().concat(": no existe en la base de datos")));
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(asignatura, HttpStatus.OK);
	}

	@PostMapping(path = "", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> createAsignatura(@Validated @RequestBody Asignatura asignatura,
			BindingResult result) {
		Asignatura asignaturaNueva = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo-> " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			asignatura.setDescripcion(asignatura.getDescripcion().toUpperCase());
			asignaturaNueva = asignaturaService.saveAsignatura(asignatura);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al crear la asignatura en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("mensaje", "La asignatura ha sido creada con éxito!");
		respuesta.put("asignatura", asignaturaNueva);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateAsignatura(@PathVariable("id") Long idAsignatura,
			@Validated @RequestBody Asignatura asignatura, BindingResult result) {
		Optional<Asignatura> asignaturaActual = asignaturaService.getAsignaturaById(idAsignatura);
		Asignatura asignaturaUpdated = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo-> " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		if (asignaturaActual.isEmpty()) {
			respuesta.put("mensaje", "Error: no se pudo editar la asignatura: "
					.concat(idAsignatura.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			//Actualización de asignatura 
			asignaturaActual.get().setDescripcion(asignatura.getDescripcion().toUpperCase());
			asignaturaActual.get().setHorarios(asignatura.getHorarios());
			asignaturaActual.get().setEmpleados(asignatura.getEmpleados());
			asignaturaActual.get().setMallas(asignatura.getMallas());
			asignaturaUpdated = asignaturaService.saveAsignatura(asignaturaActual.get());
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar el update en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		respuesta.put("mensaje", "La asignatura ha sido actualizada con exito");
		respuesta.put("asignatura", asignaturaUpdated);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Map<String, Object>> deleteAsignatura(@PathVariable("id") Long idAsignatura) {
		Map<String, Object> respuesta = new HashMap<>();
		try {
			Asignatura asignaturaRecu = asignaturaService.deleteAsignatura(idAsignatura);
			if (asignaturaRecu == null) {
				respuesta.put("mensaje", "La asignatura no existe en la base de datos");
				return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al eliminar la asignatura de la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("mensaje", "La asignatura ha sido eliminada");
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
	}

}
