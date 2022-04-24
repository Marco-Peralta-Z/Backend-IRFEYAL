package com.irfeyal.controlador.inventarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.inventarios.Aprobacion;
import com.irfeyal.modelo.inventarios.RecepcionArticulo;
import com.irfeyal.servicio.inventarios.AprobacionService;
import com.irfeyal.servicio.inventarios.RecepcionArtiService;

@RestController
@RequestMapping("/recepcionarticulo")
@CrossOrigin(origins = "*")
public class RecepcionArtiControlador {

	
	@Autowired
	RecepcionArtiService recepcionArtiService;
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<RecepcionArticulo> listAprobacion(){
		return recepcionArtiService.listAllRecepcionArticulo();
	}
}
