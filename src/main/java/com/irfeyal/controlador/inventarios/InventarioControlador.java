package com.irfeyal.controlador.inventarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
