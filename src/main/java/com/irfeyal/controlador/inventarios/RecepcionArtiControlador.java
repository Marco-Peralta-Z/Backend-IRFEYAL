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
import com.irfeyal.modelo.inventarios.Inventario;
import com.irfeyal.modelo.inventarios.RecepcionArticulo;
import com.irfeyal.servicio.inventarios.AprobacionKitService;
import com.irfeyal.servicio.inventarios.RecepcionArtiService;

@RestController
@RequestMapping("/recepcionarticulo")
@CrossOrigin(origins = "*")
public class RecepcionArtiControlador {

	
	@Autowired
	RecepcionArtiService recepcionArtiService;
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<RecepcionArticulo> listaReceArtic(){
		return recepcionArtiService.listAllRecepcionArticulo();
	}
	

	
	@GetMapping(produces = {"application/json"})
	public ResponseEntity<AprobacionKit> obtenerRecepcioArti(@RequestParam("id") Long id){
		Optional<RecepcionArticulo> recepcionArti = this.recepcionArtiService.getById(id);
		if(recepcionArti.isPresent()) {
			return new ResponseEntity(recepcionArti.get(),HttpStatus.OK);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	
}
