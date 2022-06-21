package com.irfeyal.controlador.inventarios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.inventarios.AprobacionKit;
import com.irfeyal.modelo.inventarios.Articulo;
import com.irfeyal.modelo.inventarios.Categoria;
import com.irfeyal.modelo.inventarios.DetallebajaArti;
import com.irfeyal.modelo.inventarios.Inventario;
import com.irfeyal.modelo.inventarios.Salidaarticulo;
import com.irfeyal.servicio.inventarios.AprobacionKitService;
import com.irfeyal.servicio.inventarios.ArticuloService;
import com.irfeyal.servicio.inventarios.DetalleBajaArtiService;
import com.irfeyal.servicio.inventarios.InventarioService;
import com.irfeyal.servicio.inventarios.SalidaArticuloService;

@RestController
@RequestMapping("/bajaarticulo")
@CrossOrigin(origins = "*")
public class DetallBajaArtiControlador {

	@Autowired
	DetalleBajaArtiService detalleBajaArtiService;
	
	@Autowired
	InventarioService inventarioService;
	
	@Autowired
	ArticuloService articuloService;
	
	@Autowired
	SalidaArticuloService salidaArticuloService;
	
	
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
	
	@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> crearBajaArticulo(@Validated @RequestBody DetallebajaArti detallebajaArti, BindingResult result) {
		
		DetallebajaArti newDetaBaja = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			//Guardar

			Inventario inv = inventarioService.getById(detallebajaArti.getId_inventario().getId_inventario()).get();
			if(inv.getCantidad() > 0) {
				boolean salidaArticulo = false;
				
				List<Salidaarticulo> listaSalidas = salidaArticuloService.listAllSalidaarticulo();
				
				for (int i = 0; i < listaSalidas.size(); i++) {
					if(inv.getId_inventario() == listaSalidas.get(i).getInventario().getId_inventario()) {
						salidaArticulo = true;
					}
				}
				
				if(salidaArticulo == false) {
					Articulo artiaActualizar = articuloService.getById(inv.getArticulo().getId_articulo()).get();
					artiaActualizar.setArtiestado(false);
					inv.setArticulo(artiaActualizar);
					inv.setCantidad((inv.getCantidad()-1));
					detallebajaArti.setId_inventario(inv);
					newDetaBaja = detalleBajaArtiService.save(detallebajaArti);
				}else {
					respuesta.put("error", "articulo en uso");
					return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
				}
			}
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al crear entidad");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(newDetaBaja == null) {
			respuesta.put("error", "El stock esta en 0");
			respuesta.put("detalleBaja", newDetaBaja);
		}else {

			respuesta.put("status", "ok");
			respuesta.put("detalleBaja", newDetaBaja);
		}
		
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
}
