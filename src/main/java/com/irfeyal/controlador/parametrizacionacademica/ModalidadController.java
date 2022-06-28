package com.irfeyal.controlador.parametrizacionacademica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.irfeyal.interfaces.parametrizacionacademica.ModalidadServices;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
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
@RequestMapping("/modalidad")
public class ModalidadController {

	@Autowired
	private ModalidadServices modalidadService;

	@GetMapping(path = "", produces = "application/json")
	public ResponseEntity<?> getModalidad() {
		return new ResponseEntity<>(modalidadService.getAllModalidad(), HttpStatus.OK);
	}

	@GetMapping(path = "/", produces = "application/json")
	public ResponseEntity<?> getAllModalidad(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return new ResponseEntity<>(modalidadService.getAllModalidad(pageable), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<?> getModalidadById(@PathVariable("id") Long idModalidad) {
		Optional<Modalidad> modalidad = null;
		Map<String, Object> respuesta = new HashMap<>();
		try {
			modalidad = modalidadService.getModalidadById(idModalidad);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar la consulta en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (modalidad.isEmpty()) {
			respuesta.put("mensaje",
					"La Modalidad ID: ".concat(idModalidad.toString().concat(": no existe en la base de datos")));
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(modalidad, HttpStatus.OK);
	}

	@PostMapping(path = "", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> createModalidad(@Validated @RequestBody Modalidad modalidad,
			BindingResult result) {
		Modalidad modalidadNuevo = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			// Guardando modalidad
			modalidad.setDescripcion(modalidad.getDescripcion().toUpperCase());
			modalidadNuevo = modalidadService.saveModalidad(modalidad);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al crear la modalidad en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("mensaje", "La Modadlidad ha sido creada con éxito!");
		respuesta.put("modalidad", modalidadNuevo);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateModalidad(@PathVariable("id") Long idModalidad,
			@Validated @RequestBody Modalidad modalidad,
			BindingResult result) {
		Optional<Modalidad> modalidadActual = modalidadService.getModalidadById(idModalidad);
		Modalidad modalidadUpdated = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		if (modalidadActual.isEmpty()) {
			respuesta.put("mensaje", "Error: no se pudo editar la Modalidad ID: "
					.concat(idModalidad.toString().concat(", no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			// Actualización modalidad
			modalidadActual.get().setDescripcion(modalidad.getDescripcion().toUpperCase());
			modalidadUpdated = modalidadService.saveModalidad(modalidadActual.get());
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar el update en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}

		respuesta.put("mensaje", "La Modalidad ha sido actualizado con éxito");
		respuesta.put("modalidad", modalidadUpdated);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Map<String, Object>> deleteModalidad(@PathVariable("id") Long idModalidad) {
		Map<String, Object> respuesta = new HashMap<>();
		try {
			Modalidad modalidad = modalidadService.deleteModalidad(idModalidad);
			if (modalidad == null) {
				respuesta.put("mensaje", "La Modalidad ID: " + idModalidad + " no existe en la base de datos");
				return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al eliminar la Modalidad de la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("mensaje", "La Modalidad ID: " + idModalidad + ", ha sido eliminado");
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
	}

	@GetMapping("/getJormadasPorCurso/{id_curso}")
	public List<Modalidad> buscarByCurso(@PathVariable Long id_curso) {

		return modalidadService.findByCurso(id_curso);
	}
}
