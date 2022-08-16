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

import com.irfeyal.interfaces.parametrizacionacademica.MallaServices;
import com.irfeyal.interfaces.parametrizacionacademica.PeriodoServices;
import com.irfeyal.modelo.parametrizacionacademica.Malla;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/periodo")
public class PeriodoController {

	@Autowired
	private PeriodoServices periodoService;

	@Autowired
	private MallaServices mallaService;

	@GetMapping(path = "", produces = "application/json")
	public ResponseEntity<?> getPeriodos() {
		return new ResponseEntity<>(periodoService.getAllPeriodo(), HttpStatus.OK);
	}

	@GetMapping(path = "/", produces = "application/json")
	public ResponseEntity<?> getAllPeriodos(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return new ResponseEntity<>(periodoService.getAllPeriodo(pageable), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<?> getPeriodoById(@PathVariable("id") Long idPeriodo) {
		Optional<Periodo> periodo = null;
		Map<String, Object> respuesta = new HashMap<>();
		try {
			periodo = periodoService.getPeriodoById(idPeriodo);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar la consulta en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (periodo.isEmpty()) {
			respuesta.put("mensaje",
					"El Periodo ID: ".concat(idPeriodo.toString().concat(": no existe en la base de datos")));
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(periodo, HttpStatus.OK);
	}

	@PostMapping(path = "", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> createPeriodo(@Validated @RequestBody Periodo periodo,
			BindingResult result) {
		Periodo periodoNuevo = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			periodoNuevo = periodoService.savePeriodo(periodo);

		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al crear el Periodo en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("mensaje", "El Periodo ha sido creado con éxito!");
		respuesta.put("periodo", periodoNuevo);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updatePeriodo(@PathVariable("id") Long idPeriodo, @Validated @RequestBody Periodo periodo,
			BindingResult result) {
		Optional<Periodo> periodoActual = periodoService.getPeriodoById(idPeriodo);
		Periodo periodoUpdated = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		if (periodoActual.isEmpty()) {
			respuesta.put("mensaje", "Error: no se pudo editar el Periodo: "
					.concat(idPeriodo.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			// Actualizando periodo
			// periodoActual.get().setPeriodo_academico(periodo.getPeriodo_academico().toUpperCase());
			periodoActual.get().setFecha_inicio(periodo.getFecha_inicio());
			periodoActual.get().setFecha_fin(periodo.getFecha_fin());
			periodoActual.get().setCosto_matricula(periodo.getCosto_matricula());
			periodoActual.get().setCosto_mensualidad(periodo.getCosto_mensualidad());
			periodoActual.get().setAno_inicio(periodo.getAno_inicio());//
			periodoActual.get().setAno_fin(periodo.getAno_fin());//
			periodoActual.get().setMalla(periodo.getMalla());
			periodoActual.get().setVigencia(periodo.isVigencia());
			periodoActual.get().setListaHorario(periodo.getListaHorario());
			periodoUpdated = periodoService.savePeriodo(periodoActual.get());
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar el update en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		respuesta.put("mensaje", "El Periodo ha sido actualizado con éxito");
		respuesta.put("periodo", periodoUpdated);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Map<String, Object>> deletePeriodo(@PathVariable("id") Long idPeriodo) {
		Map<String, Object> respuesta = new HashMap<>();
		try {
			Periodo periodoRecu = periodoService.deletePeriodo(idPeriodo);
			if (periodoRecu == null) {
				respuesta.put("mensaje", "El Periodo ID: " + idPeriodo + " no existe en la base de datos");
				return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al eliminar el Periodo de la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("mensaje", "El Periodo ha sido eliminado");
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
	}

	// Modulo Matricula
	@GetMapping(path = "/getPeriodoPorMalla/{id_malla}")
	public List<Periodo> getPeriodoPorMalla(@PathVariable Long id_malla) {
		return periodoService.findByMalla(id_malla);
	}
}
