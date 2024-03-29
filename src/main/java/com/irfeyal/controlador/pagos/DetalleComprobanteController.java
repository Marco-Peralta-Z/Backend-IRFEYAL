package com.irfeyal.controlador.pagos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.interfaces.pagos.IDetalleComprobanteService;
import com.irfeyal.modelo.pagos.DetalleComprobante;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class DetalleComprobanteController {

	@Autowired
	private IDetalleComprobanteService detalleComprobanteService;
	
	//listar
	@GetMapping(path="/detalleComprobante", produces = "application/json")
	public List<DetalleComprobante> index(){
		return detalleComprobanteService.findAll();
	}
	
	@GetMapping("/detalleComprobante/page/{page}")
	public Page<DetalleComprobante> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 3);
		return detalleComprobanteService.findAll(pageable);
	} 
	
	//Crear
		@PostMapping("/detalleComprobante")
		@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<?> create(@Validated @RequestBody DetalleComprobante detalleComprobante, BindingResult result){
			
			DetalleComprobante detalleComprobanteNew= null;
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
				detalleComprobanteNew= detalleComprobanteService.save(detalleComprobante);
			} catch (DataAccessException e) {
				response.put("mensaje", "Error al realizar el insert en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
			
			response.put("mensaje",	"El registro fue creado con exito");
			response.put("detalleComprobante", detalleComprobanteNew);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
		
		
		//eliminar
		@DeleteMapping("/detalleComprobante/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void delete(@PathVariable Long id) {
			detalleComprobanteService.delete(id);
		}
		
		@GetMapping("/detalleComprobante/{cedula}")
		public List<DetalleComprobante> buscarPorCedulaEstudiante(@PathVariable String cedula){
			return detalleComprobanteService.findByCedulaEstudiante(cedula); 
		}
}
