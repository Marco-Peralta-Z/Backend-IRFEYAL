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

import com.irfeyal.modelo.inventarios.AprobacionKit;
import com.irfeyal.modelo.inventarios.RecepcionArticulo;
import com.irfeyal.modelo.inventarios.Salidaarticulo;
import com.irfeyal.servicio.inventarios.AprobacionKitService;
import com.irfeyal.servicio.inventarios.SalidaArticuloService;

@RestController
@RequestMapping("/salidaarticulo")
@CrossOrigin(origins = "*")
public class SalidaAriculoControlador {

	@Autowired
	SalidaArticuloService salidaArticuloService;
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<Salidaarticulo> listaSaidaArtic(){
		return salidaArticuloService.listAllSalidaarticulo();
	}
	
	

	@GetMapping(produces = {"application/json"})
	public ResponseEntity<AprobacionKit> obtenerSalidaArti(@RequestParam("id") Long id){
		Optional<Salidaarticulo> salidaArticulo = this.salidaArticuloService.getById(id);
		if(salidaArticulo.isPresent()) {
			return new ResponseEntity(salidaArticulo.get(),HttpStatus.OK);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
