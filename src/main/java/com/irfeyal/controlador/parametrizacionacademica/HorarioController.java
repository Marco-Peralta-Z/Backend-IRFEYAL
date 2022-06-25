package com.irfeyal.controlador.parametrizacionacademica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.irfeyal.interfaces.parametrizacionacademica.HorarioServices;
import com.irfeyal.modelo.parametrizacionacademica.Horario;

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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/horario")
public class HorarioController {

	@Autowired
	private HorarioServices horarioService;

	@GetMapping(path = "", produces = "application/json")
	public ResponseEntity<?> getHorarios() {
		return new ResponseEntity<>(horarioService.getAllHorario(), HttpStatus.OK);
	}

	@GetMapping(path = "/", produces = "application/json")
	public ResponseEntity<?> getAllHorarios(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return new ResponseEntity<>(horarioService.getAllHorario(pageable), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<?> getHorarioById(@PathVariable("id") Long idHorario) {
		Optional<Horario> horario = null;
		Map<String, Object> respuesta = new HashMap<>();
		try {
			horario = horarioService.getHorarioById(idHorario);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar la consulta en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (horario.isEmpty()) {
			respuesta.put("mensaje",
					"El Horario ID: ".concat(idHorario.toString().concat(": no existe en la base de datos")));
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(horario, HttpStatus.OK);
	}

	@PostMapping(path = "", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> createHorario(@Validated @RequestBody Horario horario,
			BindingResult result) {
		Horario horarioNuevo = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			// Guardar horario
			horarioNuevo = horarioService.saveHorario(horario);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al crear el Horario en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("mensaje", "El Horario ha sido creado con éxito!");
		respuesta.put("horario", horarioNuevo);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateHorario(@PathVariable("id") Long idHorario,@Validated @RequestBody Horario horario,
			BindingResult result) {
		Optional<Horario> horarioActual = horarioService.getHorarioById(idHorario);
		Horario horarioUpdated = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		if (horarioActual.isEmpty()) {
			respuesta.put("mensaje", "Error: no se pudo editar el Horario ID: "
					.concat(idHorario.toString().concat(", no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			//Actualizar horario
			horarioActual.get().setTiempo_inicio(horario.getTiempo_inicio());
			horarioActual.get().setTiempo_fin(horario.getTiempo_fin());
			horarioActual.get().setDia(horario.getDia());
			horarioUpdated = horarioService.saveHorario(horarioActual.get());
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar el update en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		respuesta.put("mensaje", "El Horario ha sido actualizado con éxito");
		respuesta.put("Horario", horarioUpdated);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Map<String, Object>> deleteHorario(@PathVariable("id") Long idHorario) {
		Map<String, Object> respuesta = new HashMap<>();
		try {
			// Borrar horario
			Horario horarioRecu = horarioService.deleteHorario(idHorario);
			if (horarioRecu == null) {
				respuesta.put("mensaje", "El Horario ID: " + idHorario + " no existe en la base de datos");
				return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al eliminar el horario de la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("mensaje", "El Horario ha sido eliminado");
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
	}

}
