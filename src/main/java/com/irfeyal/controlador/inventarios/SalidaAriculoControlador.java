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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.inventarios.AprobacionKit;
import com.irfeyal.modelo.inventarios.Inventario;
import com.irfeyal.modelo.inventarios.ModuloLibro;
import com.irfeyal.modelo.inventarios.RecepcionArticulo;
import com.irfeyal.modelo.inventarios.Salidaarticulo;
import com.irfeyal.modelo.rolseguridad.Empleado;
import com.irfeyal.servicio.inventarios.AprobacionKitService;
import com.irfeyal.servicio.inventarios.InventarioService;
import com.irfeyal.servicio.inventarios.SalidaArticuloService;
import com.irfeyal.servicio.rolseguridad.EmpleadoService;

@RestController
@RequestMapping("/salidaarticulo")
@CrossOrigin(origins = "*")
public class SalidaAriculoControlador {

	@Autowired
	SalidaArticuloService salidaArticuloService;
	
	@Autowired
	InventarioService inventarioService;
	
	@Autowired
	EmpleadoService empleadoService;
	
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<Salidaarticulo> listaSaidaArtic(){
		return salidaArticuloService.listAllSalidaarticulo();
	}
	@GetMapping(produces = {"application/json"})
	public ResponseEntity<AprobacionKit> obtenerSalidaArti(@RequestParam("id") Long id){
		Optional<Salidaarticulo> salidaArticulo = this.salidaArticuloService.getById(id);
		if(salidaArticulo.isPresent()) {
			return new ResponseEntity(salidaArticulo.get(),HttpStatus.OK);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> crearSalidaArticulo(@Validated @RequestBody Salidaarticulo salidaArticulo, BindingResult result) {
		
		Salidaarticulo nuevaSalidaArticulo = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			//Guardar modulo
			
			Inventario inv = inventarioService.getById(salidaArticulo.getInventario().getId_inventario()).get();
			if(inv.getDisponibilidad() > 0 && inv.getCantidad() > 0 && inv.getArticulo().getArtiestado() == true && inv.getArticulo().getArtiDisponibilidad() == true) {
				Empleado emp = empleadoService.findById(salidaArticulo.getEmpleado().getId_empleado());
				inv.setDisponibilidad((inv.getDisponibilidad()-1));
				inv.getArticulo().setArtiDisponibilidad(false);
				salidaArticulo.setEmpleado(emp);
				Inventario invUpdate = inventarioService.save(inv);
				salidaArticulo.setInventario(invUpdate);
				nuevaSalidaArticulo = salidaArticuloService.save(salidaArticulo);
			}else {
				respuesta.put("status", "error");
				respuesta.put("error", "No hay disponivilidad");
				return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
			}
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al crear entidad");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("status", "ok");
		respuesta.put("salidaArticulo", nuevaSalidaArticulo);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Map<String, Object>> ingresarArticuloPrestado(@PathVariable("id") Long id) {
		Map<String, Object> respuesta = new HashMap<>();
		try {
			Salidaarticulo salidaArticulo = salidaArticuloService.delete(id);
			if (salidaArticulo == null) {
				respuesta.put("mensaje", "El articulo con id: " + id + " no existe en la base de datos");
				return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al ingresar el articulo de la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("status", "ok");
		respuesta.put("mensaje", "El articulo ha sido ingresado");
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
	}
	
	
}
