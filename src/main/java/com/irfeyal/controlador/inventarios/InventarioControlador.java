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
import com.irfeyal.servicio.inventarios.InventarioService;

@RestController
@RequestMapping("/inventario")
@CrossOrigin(origins = "*")
public class InventarioControlador {

	@Autowired
	InventarioService inventarioService;
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<Inventario> listInventario(){
		return inventarioService.listAllInventario();
	}
	
	
	
	@GetMapping(produces = {"application/json"})
	public ResponseEntity<AprobacionKit> ObteneInventario(@RequestParam("id") Long id){
		Optional<Inventario> inventario = this.inventarioService.getById(id);
		if(inventario.isPresent()) {
			return new ResponseEntity(inventario.get(),HttpStatus.OK);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
