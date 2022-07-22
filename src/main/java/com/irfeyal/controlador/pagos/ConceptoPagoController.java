package com.irfeyal.controlador.pagos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.interfaces.pagos.IConceptoPagoService;
import com.irfeyal.modelo.pagos.ConceptoPago;
import com.irfeyal.servicio.pagos.ConceptoPagoServiceImpl;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/api")

public class ConceptoPagoController {
	
	@Autowired
	private ConceptoPagoServiceImpl conceptoPagoServ;
	
	@GetMapping("/conceptoPago")
	public List<ConceptoPago> index(){
		return conceptoPagoServ.findAll();
	}
}
