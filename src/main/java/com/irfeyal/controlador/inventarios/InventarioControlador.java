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
import com.irfeyal.modelo.inventarios.ControlArticulo;
import com.irfeyal.modelo.inventarios.Inventario;
import com.irfeyal.modelo.inventarios.ModuloLibro;
import com.irfeyal.modelo.rolseguridad.Empleado;
import com.irfeyal.servicio.inventarios.ArticuloService;
import com.irfeyal.servicio.inventarios.CategoriaService;
import com.irfeyal.servicio.inventarios.ControlArticuloService;
import com.irfeyal.servicio.inventarios.InventarioService;
import com.irfeyal.servicio.rolseguridad.EmpleadoService;

@RestController
@RequestMapping("/inventario")
@CrossOrigin(origins = "*")
public class InventarioControlador {

	@Autowired
	InventarioService inventarioService;
	
	@Autowired
	ArticuloService articuloService;
	
	@Autowired
	ControlArticuloService controlArticuloService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	EmpleadoService empleadoService;
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<Inventario> listInventario(){
		return inventarioService.listAllInventario();
	}
	
	@GetMapping(produces = {"application/json"})
	public ResponseEntity<AprobacionKit> ObteneInventario(@RequestParam("id") Long id){
		Optional<Inventario> inventario = this.inventarioService.getById(id);
		if(inventario.isPresent()) {
			return new ResponseEntity(inventario.get(),HttpStatus.OK);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> ingresarNuevoArticulo(@Validated @RequestBody Inventario inventario, BindingResult result) {
		
		Inventario inventarioIngresado = null;
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
			
			Empleado empleado = empleadoService.findById(inventario.getArticulo().getControlArticulo().getAdministrador().getId_empleado());
			
			ControlArticulo newControlArticulo = controlArticuloService.save(inventario.getArticulo().getControlArticulo());
			newControlArticulo.setAdministrador(empleado);
			inventario.getArticulo().setControlArticulo(newControlArticulo);
			Categoria categoria = categoriaService.getById(inventario.getArticulo().getCateId().getId_categoria()).get();
			Articulo newArticulo = articuloService.save(inventario.getArticulo());
			newArticulo.setCateId(categoria);
			System.out.println("aaa--->"+newArticulo.getId_articulo());
			inventario.setArticulo(newArticulo);
			inventarioIngresado = inventarioService.save(inventario);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al crear entidad");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("status", "ok");
		respuesta.put("inventario", inventarioIngresado);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
}
