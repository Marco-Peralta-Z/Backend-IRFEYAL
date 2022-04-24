package com.irfeyal.controlador.inventarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.inventarios.Aprobacion;
import com.irfeyal.modelo.inventarios.Salidaarticulo;
import com.irfeyal.servicio.inventarios.AprobacionService;
import com.irfeyal.servicio.inventarios.SalidaArticuloService;

@RestController
@RequestMapping("/salidaarticulo")
@CrossOrigin(origins = "*")
public class SalidaAriculoControlador {

	@Autowired
	SalidaArticuloService salidaArticuloService;
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<Salidaarticulo> listAprobacion(){
		return salidaArticuloService.listAllSalidaarticulo();
	}
}
