package com.irfeyal.controlador.inventarios;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.inventarios.AprobacionKit;
import com.irfeyal.modelo.inventarios.Categoria;
import com.irfeyal.modelo.inventarios.ControlArticulo;
import com.irfeyal.servicio.inventarios.AprobacionKitService;
import com.irfeyal.servicio.inventarios.DetalleBajaArtiService;
import com.irfeyal.servicio.inventarios.ControlArticuloService;

@RestController
@RequestMapping("/detalleingresoarticulo")
@CrossOrigin(origins = "*")
public class ControlArtiControlador {
	
	@Autowired
	ControlArticuloService detalleIngreArtiService;
	
	@RequestMapping(value = "/crear/", method = RequestMethod.POST)
	public ResponseEntity<ControlArticulo> crearDetalIngreArti(@Valid @RequestBody ControlArticulo detalIngreArti) {
		ControlArticulo detaingreArti = detalleIngreArtiService.save(detalIngreArti);
		if (detaingreArti != null) {
			return new ResponseEntity(detaingreArti, HttpStatus.CREATED);
		} else {
			System.out.print("empleado no encontrado");
		}

		return null;

	}
	
	
	
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<ControlArticulo> listaDetalleIngreArticu(){
		return detalleIngreArtiService.listAllDetalIngreArti();
	}

	
	@GetMapping(produces = {"application/json"})
	public ResponseEntity<AprobacionKit> obtenerDetalleIngreArti(@RequestParam("id") Long id){
		Optional<ControlArticulo> ingresoArticulo = this.detalleIngreArtiService.getById(id);
		if(ingresoArticulo.isPresent()) {
			return new ResponseEntity(ingresoArticulo.get(),HttpStatus.OK);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
