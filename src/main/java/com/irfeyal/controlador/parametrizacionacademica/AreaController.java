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

import com.irfeyal.interfaces.parametrizacionacademica.AreaServices;
import com.irfeyal.modelo.parametrizacionacademica.Area;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/area")
public class AreaController {

	@Autowired
	private AreaServices areaService;

	@GetMapping(path = "", produces = "application/json")
	public ResponseEntity<?> getAreas() {
		return new ResponseEntity<>(areaService.getAllArea(), HttpStatus.OK);
	}

	@GetMapping(path = "/", produces = "application/json")
	public ResponseEntity<?> getAllAreas(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return new ResponseEntity<>(areaService.getAllArea(pageable), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<?> getAreaById(@PathVariable("id") Long idArea) {
		System.err.println("----------->" + idArea);
		Optional<Area> area = null;
		Map<String, Object> respuesta = new HashMap<>();
		try {
			area = areaService.getAreaById(idArea);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar la consulta en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (area.isEmpty()) {
			respuesta.put("mensaje",
					"El �rea ID: ".concat(idArea.toString().concat(": no existe en la base de datos")));
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(area, HttpStatus.OK);
	}

	@PostMapping(path = "", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> createArea(@Validated @RequestBody Area area, BindingResult result) {
		Area areaNueva = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo-> " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			area.setDescripcion(area.getDescripcion().toUpperCase());
			areaNueva = areaService.saveArea(area);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al crear la asignatura en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("mensaje", "La asignatura ha sido creada con �xito!");
		respuesta.put("asignatura", areaNueva);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateArea(@PathVariable("id") Long idArea, @Validated @RequestBody Area area,
			BindingResult result) {
		Optional<Area> areaActual = areaService.getAreaById(idArea);
		Area areaUpdated = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo-> " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		if (areaActual.isEmpty()) {
			respuesta.put("mensaje", "Error: no se pudo editar la asignatura: "
					.concat(idArea.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			// Actualizaci�n �rea
			areaActual.get().setDescripcion(area.getDescripcion().toUpperCase());
			areaActual.get().setListaAsignaturas(area.getListaAsignaturas());
			// Lista de asignaturas ?

			areaUpdated = areaService.saveArea(areaActual.get());
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar el update en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		respuesta.put("mensaje", "El �rea ha sido actualizada con exito");
		respuesta.put("area", areaUpdated);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Map<String, Object>> deleteArea(@PathVariable("id") Long idArea) {
		Map<String, Object> respuesta = new HashMap<>();
		try {
			Area areaRecu = areaService.deleteArea(idArea);
			if (areaRecu == null) {
				respuesta.put("mensaje", "El �rea no existe en la base de datos");
				return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al eliminar �rea de la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("mensaje", "El �rea ha sido eliminada");
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
	}

}
