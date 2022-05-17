package com.irfeyal.controlador.pagos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.interfaces.pagos.ITipoComprobanteService;
import com.irfeyal.modelo.pagos.TipoComprobante;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/api")
public class TipoComprobanteController {
	
	@Autowired
	private ITipoComprobanteService tipoComprobanteService;
	
	@GetMapping("/tipoComprobante")
	public List<TipoComprobante> index(){
		return tipoComprobanteService.findAll();
	}
	
	
	

}
