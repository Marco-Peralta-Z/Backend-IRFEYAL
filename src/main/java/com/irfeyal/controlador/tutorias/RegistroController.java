package com.irfeyal.controlador.tutorias;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
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
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import com.irfeyal.interfaces.tutorias.IRegistroService;
import com.irfeyal.modelo.pagos.Comprobante;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Malla;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Paralelo;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;
import com.irfeyal.modelo.tutorias.Registro;
import com.irfeyal.servicio.tutorias.RegistroServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/registro")
public class RegistroController {

	@Autowired
	private RegistroServiceImpl registroserviceimpl;

	@Autowired
	private IRegistroService registroservice;

	// Lista los registros
	@GetMapping("/ListarRegistros")
	public List<Registro> index() {
		return registroserviceimpl.findAll();
	}

	// Inserta un nuevo registro
	@PostMapping("/Nuevoregistro")
	public ResponseEntity<Map<String, Object>> insertarRegistro(@RequestBody Registro registro, BindingResult result) {

		Registro registronew = null;

		Map<String, Object> mensaje = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			mensaje.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.BAD_REQUEST);
		}

		try {
			registronew = registroserviceimpl.save(registro);
		} catch (DataAccessException e) {
			mensaje.put("mensaje", "Error al realizar el ingreso de registro");
			mensaje.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		mensaje.put("mensaje", "El registro fue creado con exito");
		mensaje.put("cliente", registronew);
		return new ResponseEntity<Map<String, Object>>(mensaje, HttpStatus.CREATED);
	}

	// buscar por id
	@GetMapping("ListarporId/{id_registro}")
	public ResponseEntity<?> show(@PathVariable Long id_registro) {
		Registro registro = registroserviceimpl.findById(id_registro);
		Map<String, Object> response = new HashMap<>();
		try {
			registro = registroserviceimpl.findById(id_registro);
		} catch (Exception e) {
			response.put("mensaje", "Error al realizar consulta");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		if (registro == null) {
			response.put("mensaje", "El id del registro ".concat(id_registro.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Registro>(registro, HttpStatus.OK);
	}

	// eliminar un registro por id
	@DeleteMapping(path = "{id_registro}")
	public void delete(@PathVariable Long id_registro) {
		registroserviceimpl.delete(id_registro);
	}

	@GetMapping("/Periodo")
	public List<Periodo> listarPeridod() {
		return registroserviceimpl.findAllperiodo();
	}

	@GetMapping("/Periodos/{idemple}")
	public List<Periodo> listperiodos(@PathVariable Long idemple) {
		return registroservice.Listperiodosempelados(idemple);
	}

	@GetMapping("/Malla/{idemple}/{per}")
	public List<Malla> ListMalla(@PathVariable Long idemple, @PathVariable Long per) {
		return registroservice.ListMalla(idemple, per);
	}

	@GetMapping("/Modalidades/{idemple}/{per}/{malla}")
	public List<Modalidad> listmodalidades(@PathVariable Long idemple, @PathVariable Long per,
			@PathVariable Long malla) {
		return registroservice.listmodalidadempelados(idemple, per, malla);
	}

	@GetMapping("/Cursos/{idemple}/{per}/{malla}/{idmod}")
	public List<Curso> listcurso(@PathVariable Long idemple, @PathVariable Long per, @PathVariable Long malla,
			@PathVariable Long idmod) {
		return registroservice.ListCursosempelados(idemple, per, malla, idmod);
	}

	@GetMapping("/Paralelos/{idemple}/{per}/{malla}/{idmod}/{idcurso}")
	public List<Paralelo> listparalelo(@PathVariable Long idemple, @PathVariable Long per, @PathVariable Long malla,
			@PathVariable Long idmod, @PathVariable Long idcurso) {
		return registroservice.ListParaleloempleados(idemple, per, malla, idmod, idcurso);
	}

	@GetMapping("/Asignaturas/{idemple}/{per}/{malla}/{idmod}/{idcurso}/{idparalelo}")
	public List<Asignatura> listasignatura(@PathVariable Long idemple, @PathVariable Long per, @PathVariable Long malla,
			@PathVariable Long idmod, @PathVariable Long idcurso, @PathVariable Long idparalelo) {
		return registroservice.ListAsignaturaempleados(idemple, per, malla, idmod, idcurso, idparalelo);
	}

	@GetMapping("/Filtrocompleto/{id_empleado}/{per}/{malla}/{idmod}/{idcurso}/{idparalelo}/{idasig}")
	public List<Registro> listcompleta(@PathVariable Long id_empleado, @PathVariable Long per, @PathVariable Long malla,
			@PathVariable Long idmod, @PathVariable Long idcurso, @PathVariable Long idparalelo,
			@PathVariable Long idasig) {
		return registroservice.filtrocompleto(id_empleado, per, malla, idmod, idcurso, idparalelo, idasig);
	}

	@GetMapping("/buscarestudianteporcedula/{ced}")
	public Comprobante fecha(@PathVariable String ced) {

		return registroservice.buscarceduestudiante(ced);

	}

	@GetMapping("getRegistros/{id}")
	public ResponseEntity<?> getRegisrosByMatriculaId(@PathVariable("id") Long id) {
		List<Registro> registros = null;
		Map<String, Object> response = new HashMap<>();
		try {
			registros = registroserviceimpl.getAllRegistrosByMatriculaId(id);

		} catch (Exception e) {
			response.put("status", "error");
			response.put("registro", null);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		if (registros == null) {
			response.put("status", "error");
			response.put("registro", null);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		}
		response.put("status", "ok");
		response.put("registro", registros);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("getRegistrosFilter/{idCurso}/{idMod}/{idPer}/{idPar}")
	public ResponseEntity<?> getRegisrosByCursoModalidadPeriodo(@PathVariable("idCurso") Long idCurso,
			@PathVariable("idMod") Long idMod, @PathVariable("idPer") Long idPer, @PathVariable("idPar") Long idPar) {
		List<Registro> registros = null;
		Map<String, Object> response = new HashMap<>();
		try {
			registros = registroserviceimpl.getAllRegistrosByCursoModalidadPeridod(idCurso, idMod, idPer, idPar);

		} catch (Exception e) {
			response.put("status", "error");
			response.put("registro", null);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		if (registros == null) {
			response.put("status", "error");
			response.put("registro", null);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		}
		response.put("status", "ok");
		response.put("registro", registros);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PutMapping(value = "/Update/{id_registro}")
	public ResponseEntity<Object> updateRegistro(@RequestBody Registro registro, @PathVariable Long id_registro) {
		this.registroserviceimpl.update(registro, id_registro);
		return ResponseEntity.ok(Boolean.TRUE);
	}

	/* nuevo update */
	@PutMapping("/UpdateRegistro/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody Registro registro, BindingResult result,
			@PathVariable Long id) {
		Registro registroactual = registroserviceimpl.findById(id);
		Registro registroupdate = null;
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + " '" + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}

		if (registroactual == null) {
			response.put("mensaje", "Error: no se pudo editar, el Regsitro ID: "
					.concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			registroactual.setAporte1(registro.getAporte1());
			registroactual.setAporte2(registro.getAporte2());
			registroactual.setExamen_Iquimestre(registro.getExamen_Iquimestre());
			registroactual.setPromedio_Iquimestre(registro.getPromedio_Iquimestre());
			registroactual.setAporte3(registro.getAporte3());
			registroactual.setAporte4(registro.getAporte4());
			registroactual.setExamen_IIquimestre(registro.getExamen_IIquimestre());
			registroactual.setPromedio_IIquimestre(registro.getPromedio_IIquimestre());
			registroactual.setConducta(registro.getConducta());
			registroactual.setNota_final(registro.getNota_final());
			registroactual.setExamen_supletorio(registro.getExamen_supletorio());
			registroactual.setExamen_remedial(registro.getExamen_remedial());
			registroactual.setExamen_gracia(registro.getExamen_gracia());
			registroactual.setEstado(registro.getEstado());
			registroactual.setPromedio_final(registro.getPromedio_final());
			registroupdate = registroservice.save(registroactual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}

		response.put("mensaje", "Matricula actualizada con exito");
		response.put("estudiante", registroupdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	// Para secretaria, certificado de promocion
	@GetMapping("/buscarcedulaEstudiante/{cedula}")
	public List<Registro> buscarPorCedulaEstudiante(@PathVariable String cedula) {
		return registroserviceimpl.findByCedulaEstudiante(cedula);
	}

	// Reporte PDF
	@GetMapping("/exportInvoice/{id_empleado}/{id_periodo}/{id_malla}/{id_modalidad}/{id_curso}/{id_paralelo}/{id_asignatura}")
	public @NotNull ResponseEntity<ByteArrayResource> exportinsvoice(@PathVariable Long id_empleado,
			@PathVariable Long id_periodo, @PathVariable Long id_malla, @PathVariable Long id_modalidad,
			@PathVariable Long id_curso, @PathVariable Long id_paralelo, @PathVariable Long id_asignatura) {
		return this.registroserviceimpl.exportInvoice(id_empleado, id_periodo, id_malla, id_modalidad, id_curso,
				id_paralelo, id_asignatura);
	}

}
