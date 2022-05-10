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
import com.irfeyal.modelo.inventarios.Categoria;
import com.irfeyal.modelo.inventarios.DetalIngreArti;
import com.irfeyal.servicio.inventarios.AprobacionService;
import com.irfeyal.servicio.inventarios.DetalleBajaArtiService;
import com.irfeyal.servicio.inventarios.DetalleIngreArtiService;

@RestController
@RequestMapping("/detalleingresoarticulo")
@CrossOrigin(origins = "*")
public class DetalleIngreArtiControlador {
	
	@Autowired
	DetalleIngreArtiService detalleIngreArtiService;
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<DetalIngreArti> listaDetalleIngreArticu(){
		return detalleIngreArtiService.listAllDetalIngreArti();
	}

	
	@GetMapping(produces = {"application/json"})
	public ResponseEntity<Aprobacion> obtenerDetalleIngreArti(@RequestParam("id") Long id){
		Optional<DetalIngreArti> ingresoArticulo = this.detalleIngreArtiService.getById(id);
		if(ingresoArticulo.isPresent()) {
			return new ResponseEntity(ingresoArticulo.get(),HttpStatus.OK);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
