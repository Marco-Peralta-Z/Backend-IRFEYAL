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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.rolseguridad.Empleado;
import com.irfeyal.servicio.rolseguridad.EmpleadoInterface;


@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/api")
public class EmpleadoControler {

	
	@Autowired
	private EmpleadoInterface empleadoService;
	
	@GetMapping("/empleados")
	public List<Empleado> index(){
		return empleadoService.findAll();
	}
	
	
	
	@PostMapping("/empleado")
	public ResponseEntity<?> create(@Validated @RequestBody Empleado empleado, BindingResult result){
		
		Empleado empleadoNew= null;
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors= result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +" '" + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
			
		}
		
		try {
			empleadoNew= empleadoService.saveEmpleado(empleado);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		response.put("mensaje",	"El empleado fue creado con exito");
		response.put("empleado", empleado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
