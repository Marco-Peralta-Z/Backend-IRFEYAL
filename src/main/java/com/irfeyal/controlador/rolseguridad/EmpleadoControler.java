package com.irfeyal.controlador.rolseguridad;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.irfeyal.modelo.rolseguridad.Empleado;
import com.irfeyal.servicio.rolseguridad.EmpleadoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/mapEmpleado")
public class EmpleadoControler {

	
	@Autowired
	private EmpleadoService empleadoSer;

	@GetMapping(path = { "/empleado" }, produces = "application/json")
	public List<Empleado> empleado() {
		return empleadoSer.findAll();
	}

	@DeleteMapping("/empleado/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();

		try {
			empleadoSer.findById(id);
			empleadoSer.deleteEmpleado(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al eliminar el empleado de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "empleado eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@PostMapping("/empleado")
	public ResponseEntity<?> create(@Validated @RequestBody Empleado empleado, BindingResult result) {

		Empleado newEmpleado = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("erros", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			newEmpleado = empleadoSer.saveEmpleado(empleado);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El empleado ha sido creado con exito");
		response.put("empleado", newEmpleado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/canton/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody Empleado empleado, BindingResult result, @PathVariable Long id) {
		Empleado empleadoActual = empleadoSer.findById(id);
		Empleado empleadoUpdate = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("erros", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (empleadoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el empleado ID: "
					.concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			empleadoActual.setCargo(empleado.getCargo());
			empleadoActual.setCorreo(empleado.getCorreo());
			empleadoActual.setDireccion(empleado.getDireccion());
			empleadoActual.setExtension(empleado.getExtension());
			empleadoActual.setPersona(empleado.getPersona());
			empleadoActual.setTelefono(empleado.getTelefono());
			empleadoUpdate = empleadoSer.saveEmpleado(empleadoActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al actualizar el emplado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El empleado ha sido actualizado con exito");
		response.put("empleado", empleadoUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}
	
	@GetMapping("/empleado/{cedula}")
	public List<Empleado> listaEmpleado(@PathVariable String cedula) {
		return empleadoSer.findAllByCedula(cedula);
	}

}
