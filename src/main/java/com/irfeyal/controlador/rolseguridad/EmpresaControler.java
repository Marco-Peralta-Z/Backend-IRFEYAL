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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.rolseguridad.Empresa;
import com.irfeyal.servicio.rolseguridad.EmpresaService;



@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapEmpresa")
public class EmpresaControler {
	
	
	@Autowired
	 private EmpresaService empresaService;
	
	@GetMapping ("/empresa")
	
	public List<Empresa> empresa(){
	 return empresaService.findAll();
	}
	public List<Empresa> empresadel(Long  id){
		 return (List<Empresa>) empresaService.findById(id);
		}
		
	@PostMapping("/empresa")
	public ResponseEntity<?> create(@Validated @RequestBody Empresa empresa, BindingResult result) {
		
		
		Empresa empresaNew= null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +"' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("erros", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		
		try {
			empresaNew= empresaService.saveEmpresa(empresaNew);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje","El cliente ha sido creado con exito");
		response.put("cliente", empresaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/empresa/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody Empresa empresa,BindingResult result, @PathVariable Long id) {
		Empresa empresaActual = empresaService.findById(id);
		Empresa empresaUpdate= null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +"' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("erros", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		
		
		if (empresaActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el cliente ID: ".concat(id.toString().concat(", no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
			
		try {
		
		empresaActual.setNombre_empresa(empresa.getNombre_empresa());
		empresaUpdate= empresaService.saveEmpresa(empresaActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erros al actualizar el cliente en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","La empresa ha sido actualizado con exito");
		response.put("cliente", empresaUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
		
	public List<Empresa> empresaupd(){
		 return empresaService.updateEmpresa();
		}
		
	
}
