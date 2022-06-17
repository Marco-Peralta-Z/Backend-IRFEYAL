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
import com.irfeyal.modelo.inventarios.DetallebajaArti;
import com.irfeyal.servicio.inventarios.AprobacionKitService;
import com.irfeyal.servicio.inventarios.DetalleBajaArtiService;

@RestController
@RequestMapping("/bajaarticulo")
@CrossOrigin(origins = "*")
public class DetallBajaArtiControlador {

	@Autowired
	DetalleBajaArtiService detalleBajaArtiService;
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<DetallebajaArti> listDetallBajaArti(){
		return detalleBajaArtiService.listAllDetallebajaArti();
	}
	
	@GetMapping(produces = {"application/json"})
	public ResponseEntity<AprobacionKit> obtener(@RequestParam("id") Long id){
		Optional<DetallebajaArti> detalleBajaArticulo = this.detalleBajaArtiService.getById(id);
		if(detalleBajaArticulo.isPresent()) {
			return new ResponseEntity(detalleBajaArticulo.get(),HttpStatus.OK);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
