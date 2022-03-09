package com.example.demo.controlers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Estudiante;
import com.example.demo.services.IEstudianteService;


@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class EstudianteRestController {

	
	@Autowired
	private IEstudianteService estudianteService;
	
	
	@GetMapping("/estudiantes")
	public List<Estudiante> index(){
		return estudianteService.findAll();
	}
	
	@GetMapping("/clientes/page/{page}")
	public Page<Estudiante> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page,3);
		return estudianteService.findAll(pageable);
	}
	
	
	@PostMapping("/estudiante")
	public ResponseEntity<?> create(@Validated @RequestBody Estudiante estudiante, BindingResult result){
		
		Estudiante estudentNew= null;
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
			estudentNew= estudianteService.save(estudiante);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		response.put("mensaje",	"El estudiante fue creado con exito");
		response.put("estudiante", estudentNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
