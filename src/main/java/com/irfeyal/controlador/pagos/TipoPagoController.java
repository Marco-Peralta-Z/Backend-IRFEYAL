package com.irfeyal.controlador.pagos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.pagos.TipoPago;
import com.irfeyal.interfaces.pagos.ITipoPagoService;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/api")

public class TipoPagoController {

	@Autowired
	private ITipoPagoService tipoPagoService;
	
	//Listar
	@GetMapping("/tipo_pago")
	public List<TipoPago> index(){
		return tipoPagoService.findAll();
	}
	
	//Guardar
	@PostMapping("/tipo_pago")
	@ResponseStatus(HttpStatus.CREATED)
	public TipoPago save(@RequestBody TipoPago tipoPago) {
		return tipoPagoService.save(tipoPago);
	}
	
	//Buscar por Id
	@GetMapping("/tipo_pago/{id}")
	public TipoPago show(@PathVariable Long id) {
		return tipoPagoService.findById(id);
	}
	
	//Eliminar
	@DeleteMapping("/tipo_pago/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		tipoPagoService.delete(id);
	}
}
