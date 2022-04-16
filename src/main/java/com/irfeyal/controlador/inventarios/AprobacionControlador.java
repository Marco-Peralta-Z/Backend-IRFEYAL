package com.irfeyal.controlador.inventarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.inventarios.Aprobacion;
import com.irfeyal.servicio.inventarios.AprobacionService;


@RestController
@RequestMapping("/aprobacion")
@CrossOrigin(origins = "*")
public class AprobacionControlador {

	@Autowired
	AprobacionService aprobacionService;
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<Aprobacion> listAprobacion(){
		return aprobacionService.listAllAprobacion();
	}
	
	@GetMapping(path = "detalleapro/{id}")
	public Object obtenerAprobacionId(@PathVariable("id") Integer id){
		return aprobacionService.getDetalleAprobacion(id);
	}
	
	
	
	
}
