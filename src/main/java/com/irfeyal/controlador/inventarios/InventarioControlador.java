package com.irfeyal.controlador.inventarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import org.springframework.web.bind.annotation.PathVariable;
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
import com.irfeyal.modelo.inventarios.Kit;
import com.irfeyal.modelo.inventarios.ModuloLibro;
import com.irfeyal.modelo.inventarios.StockArticulo;
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

	@GetMapping(path = "/list", produces = { "application/json" })
	public List<StockArticulo> listInventario() {
		List<Categoria> listaCategorias = categoriaService.listAllCategoria();
		List<Inventario> listaInventario = inventarioService.listAllInventario();
		List<StockArticulo> listaTemp = new ArrayList<>();
		for (int i = 0; i < listaCategorias.size(); i++) {
			StockArticulo newStockArti = new StockArticulo();
			int cantidad = 0;
			List<Articulo> articulos = new ArrayList<>();
			for (int j = 0; j < listaInventario.size(); j++) {
				if (listaInventario.get(j).getArticulo().getCateId().getId_categoria() == listaCategorias.get(i)
						.getId_categoria() && listaInventario.get(j).getArticulo().getArtiestado() == true) {
					articulos.add(listaInventario.get(j).getArticulo());
					cantidad = cantidad + 1;
				}
			}
			newStockArti.setCategoria(listaCategorias.get(i).getCateNombre());
			newStockArti.setCantidad(cantidad);
			newStockArti.setListaArticulos(articulos);
			listaTemp.add(newStockArti);
		}
		return listaTemp;
	}

	@GetMapping(path = "/listarticulos", produces = { "application/json" })
	public List<Inventario> listaTodosArticulos() {
		List<Inventario> listaInventario = inventarioService.listAllInventario();
		List<Inventario> temP = new ArrayList<>();
		for (int j = 0; j < listaInventario.size(); j++) {
			if (listaInventario.get(j).getArticulo().getArtiestado() == true) {
				temP.add(listaInventario.get(j));
			}
		}
		return temP;
	}
	
	
	@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> ingresarNuevoArticulo(@Validated @RequestBody Inventario inventario,
			BindingResult result) {

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
			// Guardar
			Empleado empleado = empleadoService
					.findById(inventario.getArticulo().getControlArticulo().getAdministrador().getId_empleado());
			ControlArticulo newControlArticulo = controlArticuloService
					.save(inventario.getArticulo().getControlArticulo());
			newControlArticulo.setCantidad(1);
			newControlArticulo.setAdministrador(empleado);
			inventario.getArticulo().setControlArticulo(newControlArticulo);
			Categoria categoria = categoriaService.getById(inventario.getArticulo().getCateId().getId_categoria())
					.get();
			inventario.getArticulo().setArticodigo("01" + newControlArticulo.getId_control_articulo());
			Articulo newArticulo = articuloService.save(inventario.getArticulo());
			newArticulo.setCateId(categoria);
			newArticulo.setArtiestado(true);
			newArticulo.setArtiDisponibilidad(true);
			inventario.setDisponibilidad(inventario.getCantidad());
			inventario.setArticulo(newArticulo);
			inventario.setCodigo("01" + newArticulo.getId_articulo());
			inventario.setIngresadoPor(empleado.getPersona().getNombre() + empleado.getPersona().getApellido()
					+ ": Ci: " + empleado.getPersona().getCedula());
			
			inventario.setCantidad(1);
			inventario.setDisponibilidad(1);
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

	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<?> buscarInventario(@PathVariable("id") Long id) {
		Map<String, Object> respuesta = new HashMap<>();
		try {
			List<Inventario> listaInven = inventarioService.listAllInventario();
			for (int i = 0; i < listaInven.size(); i++) {
				if (listaInven.get(i).getArticulo().getId_articulo() == id) {
					Optional<Inventario> inv = inventarioService.getById(listaInven.get(i).getId_inventario());
					if (inv.isPresent()) {
						respuesta.put("status", "ok");
						respuesta.put("inventario", inv.get());
						return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
					} else {
						respuesta.put("status", null);
						return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
					}
				}
			}
			respuesta.put("status", null);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta.put("error", e);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
		}

	}

}
