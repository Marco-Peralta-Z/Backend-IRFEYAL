package com.irfeyal.controlador.asistencia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.interfaces.asistencia.IAsistenciaService;
import com.irfeyal.interfaces.asistencia.IClaseService;
import com.irfeyal.interfaces.parametrizacionacademica.AsignaturaServices;
import com.irfeyal.interfaces.parametrizacionacademica.PeriodoServices;
import com.irfeyal.modelo.asistencia.Asistencia;
import com.irfeyal.modelo.asistencia.Clase;
import com.irfeyal.modelo.matricula.Estudiante;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Paralelo;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;
import com.irfeyal.modelo.rolseguridad.Persona;
import com.irfeyal.servicio.matricula.EstudianteServiceImpl;

@RestController
@RequestMapping("/asistencia")
@CrossOrigin(origins = "*")
public class AsistenciaController {

	@Autowired
	private IAsistenciaService asistenciaservice;

	@Autowired
	private IClaseService claseservice;

	@Autowired
	private AsignaturaServices asignaturaservice;
	@Autowired
	private PeriodoServices periodoService;
	@Autowired
	private EstudianteServiceImpl estudiante;

	@GetMapping("/asist/{id}")
	public ResponseEntity<?> showe(@PathVariable Long id) {
		Estudiante asistencia = estudiante.findById(id);
		Map<String, Object> response = new HashMap<>();
		try {
			asistencia = estudiante.findById(id);
		} catch (Exception e) {
			response.put("mensaje", "Error al realizar consulta");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		if (asistencia == null) {
			response.put("mensaje", "El id del cliente ".concat(id.toString().concat("no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Estudiante>(asistencia, HttpStatus.OK);
	}

	@GetMapping("/listarasistencia")
	public List<Asistencia> index() {
		return asistenciaservice.findAll();

	}

	@GetMapping("/asignaturas")
	public List<Asignatura> listarRegiones() {
		return asistenciaservice.findAllAsignaturas();
	}

	@GetMapping("/Modalidad")
	public List<Modalidad> listarModalidad() {
		return asistenciaservice.findAllModalidad();
	}

	@GetMapping("/Periodo")
	public List<Periodo> listarPeridod() {
		return asistenciaservice.findAllperio();
	}

	@GetMapping("/Curso")
	public List<Curso> listarCurso() {
		return asistenciaservice.findAllcurso();
	}

	@GetMapping("/Paralelo")
	public List<Paralelo> listarParalelo() {
		return asistenciaservice.findAllParalelo();
	}

	@PostMapping("/asistenciasave")
	public ResponseEntity<Asistencia> save(@RequestBody Asistencia asistencia) {
		Asistencia obj = asistenciaservice.save(asistencia);

		return new ResponseEntity<Asistencia>(obj, HttpStatus.OK);
	}

	@GetMapping("/claseingresada")
	public Clase claseingresada() {
		// corregir return claseservice.ultimoingreso();
		return null;
	}

	@PostMapping("/clasesave")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createclase(@Validated @RequestBody Clase asistencia, BindingResult result) {

		Clase asistenciaNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			asistenciaNew = claseservice.save(asistencia);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El cliente ha sido creado con éxito!");
		response.put("cliente", asistenciaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@GetMapping("/listarclase")
	public List<Clase> findAll() {
		return claseservice.findAll();
	}

	@GetMapping("/asistenciadelete/{id}")
	public ResponseEntity<Asistencia> delete(@PathVariable Long id) {
		Asistencia asistencia = asistenciaservice.findById(id);
		if (asistencia != null) {
			asistenciaservice.delete(id);
		} else {
			return new ResponseEntity<Asistencia>(asistencia, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Asistencia>(asistencia, HttpStatus.OK);

	}

	@GetMapping("/buscarestudiantesdeuncurso/{id}")
	public List<Persona> buscarcurso(@PathVariable Long id) {

		return asistenciaservice.buscarcurso(id);

	}

	@GetMapping("/filtrosdelaasistencia/{idmod}/{idper}/{idpar}/{idasig}/{idcurs}")
	public List<Estudiante> filtros(@PathVariable Long idmod, @PathVariable Long idper, @PathVariable Long idpar,
			@PathVariable Long idasig, @PathVariable Long idcurs) {

		return asistenciaservice.buscarcursomodalidad(idmod, idper, idpar, idasig, idcurs);

	}

	@GetMapping("/mostrarfechasdefaltas/{ides}/{iddo}")
	public List<Clase> fechas(@PathVariable Long ides, @PathVariable Integer iddo) {

		return claseservice.mostrarfechas(ides, iddo);

	}

	@GetMapping("/buscarestudianteporcedula/{ced}")
	public Estudiante fecha(@PathVariable String ced) {

		return asistenciaservice.buscarceduestudiante(ced);

	}

}
