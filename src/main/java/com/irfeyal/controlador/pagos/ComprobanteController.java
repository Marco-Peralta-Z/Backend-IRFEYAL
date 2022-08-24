package com.irfeyal.controlador.pagos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.interfaces.pagos.IComprobanteService;
import com.irfeyal.modelo.inventarios.Kit;
import com.irfeyal.modelo.pagos.Comprobante;
import com.irfeyal.servicio.inventarios.IKitService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ComprobanteController {

	@Autowired
	private IComprobanteService comprobanteService;
	
	@Autowired//(required = false)
	//@Qualifier("IAutoServiceImplement")
	IKitService kitService;
	
	//listar
	@GetMapping(path= "/comprobante", produces = "application/json")
	public List<Comprobante> index(){
		return comprobanteService.findAll();
	}
	
	@GetMapping("/comprobante/page/{page}")
	public Page<Comprobante> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 3);
		return comprobanteService.findAll(pageable);
	} 
	
	//guardar
	@PostMapping("/comprobante")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@Validated @RequestBody Comprobante comprobante, BindingResult result){
		
		Comprobante comprobanteNew= null;
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors= result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() +" '" + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
			
		}
		
		try {
			comprobanteNew= comprobanteService.save(comprobante);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		response.put("mensaje",	"El registro fue creado con exito");
		response.put("comprobante", comprobanteNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	//borrar
	@DeleteMapping("/comprobante/{id}")
	public void delete(@PathVariable Long id) {
		comprobanteService.delete(id);
	}
	
	
	
	@GetMapping(path = "/comprobante/{id}", produces = "application/json")
	public ResponseEntity<?> obtenerKit(@PathVariable("id") Long id) {
		Map<String, Object> respuesta = new HashMap<>();
		Integer optionalKit = this.kitService.getKitParaPagos(id);
		if(optionalKit != null) {
			respuesta.put("status", "ok");
			respuesta.put("precioKit", optionalKit);
			return new ResponseEntity<Map<String, Object>>(respuesta,HttpStatus.OK);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping(path = "/comprobante/{idMa}/{idConcepto}", produces = "application/json")
	public ResponseEntity<?> obtenerComprobateSaldo(@PathVariable("idMa") Long idMa, @PathVariable("idConcepto") Long idConcepto) {
		Map<String, Object> respuesta = new HashMap<>();
		Comprobante comprobante = null;
		try {
			comprobante = comprobanteService.buscarPorEstadoAndMatriculaAndTipocomprobante(false, idMa, idConcepto);
			respuesta.put("status", "ok");
			respuesta.put("comprobante", comprobante);
		} catch (Exception e) {
			respuesta.put("status", "error");
			respuesta.put("comprobante", null);
			return new ResponseEntity<Map<String, Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(comprobante == null) {
			respuesta.put("status", "error");
			respuesta.put("comprobante", null);
			return new ResponseEntity<Map<String, Object>>(respuesta,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Map<String, Object>>(respuesta,HttpStatus.OK);
	}
	
	@PutMapping(path = "/comprobante/{id}", produces = "application/json")
	public ResponseEntity<?> actualizarEstadoComprobante(@PathVariable("id") Long id) {
		Map<String, Object> respuesta = new HashMap<>();
		Comprobante comprobanteActual = comprobanteService.findById(id);
		if(comprobanteActual == null) {
			respuesta.put("status", "error");
			respuesta.put("comprobante", null);
			return new ResponseEntity<Map<String, Object>>(respuesta,HttpStatus.NOT_FOUND);
		}
		Comprobante comprobanteNew = null;
		try {
			comprobanteActual.setEstado(true);
			comprobanteNew = comprobanteService.save(comprobanteActual);
			respuesta.put("status", "ok");
			respuesta.put("comprobante", comprobanteNew);
		} catch (Exception e) {
			respuesta.put("status", "error");
			respuesta.put("comprobante", null);
			return new ResponseEntity<Map<String, Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(respuesta,HttpStatus.OK);
	}
	
	
	
}
