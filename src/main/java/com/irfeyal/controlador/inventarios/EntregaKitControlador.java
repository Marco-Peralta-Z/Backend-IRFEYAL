package com.irfeyal.controlador.inventarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.inventarios.EntregaKit;
import com.irfeyal.servicio.inventarios.EntregaKitService;


@RestController
@RequestMapping("/entregakit")
@CrossOrigin(origins = "*")
public class EntregaKitControlador {

	@Autowired//(required = false)
	//@Qualifier("IAutoServiceImplement")
	EntregaKitService entregaKitService;
	
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<EntregaKit> listIngresoKit(){
		return entregaKitService.listAllEntregaKit();
		
	}
	
	
	
	
}
