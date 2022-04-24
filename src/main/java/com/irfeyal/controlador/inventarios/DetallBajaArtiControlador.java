package com.irfeyal.controlador.inventarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.inventarios.Aprobacion;
import com.irfeyal.modelo.inventarios.DetallebajaArti;
import com.irfeyal.servicio.inventarios.AprobacionService;
import com.irfeyal.servicio.inventarios.DetalleBajaArtiService;

@RestController
@RequestMapping("/detallebajaarticulo")
@CrossOrigin(origins = "*")
public class DetallBajaArtiControlador {

	@Autowired
	DetalleBajaArtiService detalleBajaArtiService;
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<DetallebajaArti> listDetallBajaArti(){
		return detalleBajaArtiService.listAllDetallebajaArti();
	}
}
