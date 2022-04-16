package com.irfeyal.controlador.inventarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.inventarios.IngresoKit;
import com.irfeyal.servicio.inventarios.IingresoKitService;


@RestController
@RequestMapping("/ingresokit")
@CrossOrigin(origins = "*")
public class IngresoKitControlador {
	
	@Autowired//(required = false)
	//@Qualifier("IAutoServiceImplement")
	IingresoKitService ingresoKitServicio;
	
	@PostMapping(path = "/add/")
	public IngresoKit guardarIngresoKit(@RequestBody IngresoKit ingresoKit) {
		return this.ingresoKitServicio.save(ingresoKit);
	}
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<IngresoKit> listIngresoKit(){
		return ingresoKitServicio.listAllIngresoKit();
		
	}
	

}
