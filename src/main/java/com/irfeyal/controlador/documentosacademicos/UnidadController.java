package com.irfeyal.controlador.documentosacademicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.documentosacademicos.Unidad;
import com.irfeyal.servicio.documentosacademicos.UnidadService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping ("/unidades/")
public class UnidadController {
	
	@Autowired
	private UnidadService unidadService;
	
	@GetMapping
	private ResponseEntity<List<Unidad>> getAllUnidades (){
		return ResponseEntity.ok(unidadService.findAll());
	}

}
