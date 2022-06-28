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
import com.irfeyal.interfaces.parametrizacionacademica.CursoServices;
import com.irfeyal.modelo.parametrizacionacademica.Curso;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoServices cursoService;

	@GetMapping(path = "", produces = "application/json")
	public ResponseEntity<?> getCursos() {
		return new ResponseEntity<>(cursoService.getAllCurso(), HttpStatus.OK);
	}

	@GetMapping(path = "/", produces = "application/json")
	public ResponseEntity<?> getAllCursos(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return new ResponseEntity<>(cursoService.getAllCurso(pageable), HttpStatus.OK);

	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<?> getCursoById(@PathVariable("id") Long idCurso) {
		Optional<Curso> curso = null;
		Map<String, Object> respuesta = new HashMap<>();
		try {
			curso = cursoService.getCursoById(idCurso);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar la consulta en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (curso.isEmpty()) {
			respuesta.put("mensaje",
					"El curso ID: ".concat(idCurso.toString().concat(": no existe en la base de datos")));
			return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(curso, HttpStatus.OK);
	}

	@PostMapping(path = "", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> createCurso(@Validated @RequestBody Curso curso, BindingResult result) {
		Curso cursoNuevo = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			curso.setDescripcion(curso.getDescripcion().toUpperCase());
			cursoNuevo = cursoService.saveCurso(curso);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al crear el curso en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("mensaje", "El curso ha sido creado con éxito!");
		respuesta.put("curso", cursoNuevo);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateCurso(@PathVariable("id") Long idCurso,@Validated @RequestBody Curso curso,
			BindingResult result) {
		Optional<Curso> cursoActual = cursoService.getCursoById(idCurso);
		Curso cursoUpdated = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		if (cursoActual.isEmpty()) {
			respuesta.put("mensaje", "Error: no se pudo editar el curso: "
					.concat(idCurso.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			//Actaualización de curso
			cursoActual.get().setDescripcion(curso.getDescripcion());
			cursoUpdated = cursoService.saveCurso(cursoActual.get());
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar el update en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}

		respuesta.put("mensaje", "El curso ha sido actualizado con éxito");
		respuesta.put("curso", cursoUpdated);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Map<String, Object>> deleteCurso(@PathVariable("id") Long idCurso) {
		Map<String, Object> respuesta = new HashMap<>();
		try {
			Curso cursoRecu = cursoService.deleteCurso(idCurso);
			if (cursoRecu == null) {
				respuesta.put("mensaje", "El curso ID: " + idCurso + " no existe en la base de datos");
				return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al eliminar el Curso de la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("mensaje", "El curso ha sido eliminado");
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
	}
}
