package com.irfeyal.controlador.asistencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.bind.annotation.PutMapping;
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
import com.irfeyal.modelo.rolseguridad.Empleado;
import com.irfeyal.modelo.rolseguridad.Persona;
import com.irfeyal.modelo.rolseguridad.Usuario;
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
	@GetMapping("/Periodos/{idempl}")
	public List<Periodo> listarPeridods(@PathVariable Long idempl) {
		return asistenciaservice.listarpaeriodo(idempl);
	}
	@GetMapping("/modalidades/{idempl}/{idmod}")
	public List<Modalidad> listarmodalidades(@PathVariable Long idempl,@PathVariable Long idmod) {
		return asistenciaservice.listarmodalidad(idempl, idmod);
	}
	@GetMapping("/cursos/{idempl}/{periodo}/{idmod}")
	public List<Curso> listarcurso(@PathVariable Long idempl,@PathVariable Long periodo,@PathVariable Long idmod) {
		return asistenciaservice.listarcurso(idempl,periodo,idmod);
	}
	@GetMapping("/paralelos/{idempl}/{periodo}/{modalidad}/{idcurso}")
	public List<Paralelo> listarparalelo(@PathVariable Long idempl,@PathVariable Long periodo,@PathVariable Long modalidad,@PathVariable Long idcurso) {
		return asistenciaservice.listarparalelo(idempl,periodo,modalidad,idcurso);
	}
	@GetMapping("/asignaturas/{empelado}/{idperiodo}/{modalidad}/{idcurso}/{idparalelo}")
	public List<Asignatura> listarasignatura(@PathVariable Long empelado , @PathVariable Long idperiodo,@PathVariable Long modalidad, @PathVariable Long idcurso,@PathVariable Long idparalelo) {
		return asistenciaservice.listarasignatura(empelado, idperiodo,modalidad, idcurso, idparalelo);
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

	public Clase claseingresada(){
		//corregir return claseservice.ultimoingreso();
		return claseservice.ultimoingreso();
	}

	@PostMapping("/clasesave")
	@ResponseStatus(HttpStatus.CREATED)

public ResponseEntity<?> createclase(@Validated @RequestBody Clase clase, BindingResult result) {
		
		Clase claseNew = null;

	
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {

			claseNew = claseservice.save(clase);
		
		} catch (DataAccessException e) {

			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
		response.put("mensaje", "la clase ha sido creado con éxito!");
		response.put("cliente", claseNew);


		
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

	//@GetMapping("/mostrarfechasdefaltas/{ides}/{iddo}")
//	public List<Clase> fechas(@PathVariable Long ides, @PathVariable Integer iddo) {

	//	return claseservice.mostrarfechas(ides, iddo);
///
	//}

	@GetMapping("/buscarestudianteporcedula/{ced}")
	public Estudiante fecha(@PathVariable String ced) {

		return asistenciaservice.buscarceduestudiante(ced);

	}

	
	@GetMapping("/buscarestudianteid/{id}")
	public List<Estudiante> estudianteid(@PathVariable Long id ){
		
		
		return asistenciaservice.mostrarinformacion(id);
		
	}
	
	
	@GetMapping("/buscaractualizar/{id_mod}/{id_periodo}/{id_paralelo}/{id_asignatura}/{id_curso}/{fecha}/{docente}")
	public List<Asistencia> buscaractualizar(@PathVariable Long id_mod,@PathVariable Long id_periodo,@PathVariable Long id_paralelo,@PathVariable Long id_asignatura,@PathVariable Long id_curso,@PathVariable String fecha,@PathVariable Long docente ) throws ParseException{
SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
	Date auxfecha= formato.parse(fecha);
		return asistenciaservice.burcarasistencia(id_mod, id_periodo, id_paralelo, id_asignatura, id_curso, auxfecha,docente);
	}
	
	
	@PutMapping("/updateasistencia/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	
	public ResponseEntity<?> update(@Validated @RequestBody Asistencia usuario, BindingResult result, @PathVariable Long id) {

	Asistencia usuActual = asistenciaservice.findById(id);

	Asistencia usuUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (usuActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el cliente ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			usuActual.setEstadoAsis(usuario.getEstadoAsis());
			

			usuUpdated = asistenciaservice.save(usuActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la falta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El cliente ha sido actualizado con éxito!");
		response.put("cliente", usuUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	

	@PutMapping("/claseactualizar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Clase update(@RequestBody Clase clase, @PathVariable Long id) {
		Clase currentCliente = this.claseservice.findById(id);
		currentCliente.setFecClase(clase.getFecClase());
		currentCliente.setId_modalidad(clase.getId_modalidad());
		currentCliente.setIdCurso(clase.getIdCurso());
		currentCliente.setIdAsignatura(clase.getIdAsignatura());
		currentCliente.setId_periodo(clase.getIdPeriodo());
		currentCliente.setIdParalelo(clase.getIdParalelo());
		this.claseservice.save(currentCliente);
		return currentCliente;
	}

@GetMapping("/mostrarfechasdefaltas/{ides}/{iddo}/{idasig}/{idcur}/{idpar}/{idmod}/{idperi}")
	public List<Clase> fechas(@PathVariable Long ides, @PathVariable Integer iddo,@PathVariable Integer idasig,@PathVariable Integer idcur,@PathVariable Integer idpar,@PathVariable Integer idmod,@PathVariable Integer idperi ) {

		
		return claseservice.mostrarfechas(ides, iddo, idasig, idcur, idpar, idmod, idperi);

	}


@GetMapping("/validarclase/{id_mod}/{id_periodo}/{id_paralelo}/{id_asignatura}/{id_curso}/{fecha}/{docente}")
public List<Asistencia> validarclase(@PathVariable Long id_mod,@PathVariable Long id_periodo,@PathVariable Long id_paralelo,@PathVariable Long id_asignatura,@PathVariable Long id_curso,@PathVariable String fecha,@PathVariable Long docente ) throws ParseException{
	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
	Date auxfecha= formato.parse(fecha);
		return asistenciaservice.burcarasistencia(id_mod, id_periodo, id_paralelo, id_asignatura, id_curso, auxfecha,docente);
}





@GetMapping("/validarclass/{id_doc}/{id_periodo}/{id_mod}/{id_curso}/{id_paralelo}/{id_asignatura}/{fechac}")
public Long validarclass(@PathVariable Integer id_doc,@PathVariable Integer id_periodo,@PathVariable Integer id_mod,@PathVariable Integer id_curso,@PathVariable Integer id_paralelo,@PathVariable Integer id_asignatura,@PathVariable String fechac ) throws ParseException{
	System.out.print("fecha para comprobar consulta"+ fechac);
SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
Date auxfecha= formato.parse(fechac);
System.out.print("fecha para comprobar consulta "+auxfecha);
	return claseservice.validarclass(id_doc, id_periodo, id_mod, id_curso, id_paralelo, id_asignatura, auxfecha);
}

}
