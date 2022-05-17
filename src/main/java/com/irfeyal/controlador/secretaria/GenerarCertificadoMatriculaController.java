package com.irfeyal.controlador.secretaria;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.interfaces.secretaria.IGenerarCertificadoMatriculaService;
import com.irfeyal.modelo.secretaria.GenerarCertificadoMatricula;


@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/api")
public class GenerarCertificadoMatriculaController {

	@Autowired
	private IGenerarCertificadoMatriculaService generarCertificadoMatriculaService;
	
	//listar
	@GetMapping("/certificadoMatricula")
	public List<GenerarCertificadoMatricula>index(){
		return generarCertificadoMatriculaService.findAll();
	}
	
	
	//crear
	@PostMapping("/certificadoMatricula")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@Validated @RequestBody GenerarCertificadoMatricula certificadoMatricuala, BindingResult result){
		
		GenerarCertificadoMatricula certificadoMatriculaNew= null;
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
			certificadoMatriculaNew= generarCertificadoMatriculaService.save(certificadoMatricuala);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		response.put("mensaje",	"El certificado fue creado con exito");
		response.put("certificadoMatricula", certificadoMatriculaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	//eliminar
	@DeleteMapping("/certificadoMatricula/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		generarCertificadoMatriculaService.delete(id);
	}
	
	
}
