package com.irfeyal.controlador.inventarios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.inventarios.Aprobacion;
import com.irfeyal.modelo.inventarios.DetalIngreArti;
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
	public List<EntregaKit> listaEntregaKi(){
		return entregaKitService.listAllEntregaKit();
		
	}
	
	@GetMapping(produces = {"application/json"})
	public ResponseEntity<Aprobacion> obtenerEntregaKit(@RequestParam("id") Long id){
		Optional<EntregaKit> entregaKit = this.entregaKitService.getById(id);
		if(entregaKit.isPresent()) {
			return new ResponseEntity(entregaKit.get(),HttpStatus.OK);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
