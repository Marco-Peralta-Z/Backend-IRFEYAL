package com.irfeyal.controlador.inventarios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.inventarios.AprobacionKit;
import com.irfeyal.modelo.inventarios.Categoria;
import com.irfeyal.modelo.inventarios.ModuloLibro;
import com.irfeyal.servicio.inventarios.AprobacionKitService;
import com.irfeyal.servicio.inventarios.CategoriaService;

@RestController
@RequestMapping("/categoriarticulo")
@CrossOrigin(origins = "*")
public class CategoriaControlador {

	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<Categoria> listCategoria(){
		return categoriaService.listAllCategoria();
	}
	
	@GetMapping(produces = {"application/json"})
	public ResponseEntity<AprobacionKit> obtenerCategria(@RequestParam("id") Long id){
		Optional<Categoria> categoria = this.categoriaService.getById(id);
		if(categoria.isPresent()) {
			return new ResponseEntity(categoria.get(),HttpStatus.OK);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> crearCategoria(@Validated @RequestBody Categoria categoria, BindingResult result) {
		
		Categoria categoriaNew = null;
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
			categoriaNew = categoriaService.save(categoria);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al crear entidad");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("status", "ok");
		respuesta.put("categoria", categoriaNew);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Map<String, Object>> deleteCategoria(@PathVariable("id") Long id) {
		Map<String, Object> respuesta = new HashMap<>();
		try {
			Categoria categoria = categoriaService.delete(id);
			if (categoria == null) {
				respuesta.put("mensaje", "El modulo con id: " + id + " no existe en la base de datos");
				return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al eliminar el modulo de la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			respuesta.put("status", "error relacion");
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("status", "ok");
		respuesta.put("mensaje", "La categoria ha sido eliminada");
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
	}
	
	@PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> actualizarCategoria(@PathVariable("id") Long idCategoria, @Validated @RequestBody Categoria categoria,
			BindingResult result) {
		Categoria categoriaActual = categoriaService.getById(idCategoria).get();
		Categoria categoriaUpdate = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		if (categoriaActual == null) {
			respuesta.put("mensaje", "Error: no se pudo editar la categoria: "
					.concat(idCategoria.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			//Actualizando kit
			categoriaActual.setCateCodigo(categoria.getCateCodigo());
			categoriaActual.setCateNombre(categoria.getCateNombre());
			
			categoriaUpdate = categoriaService.save(categoriaActual);
			
			
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar el update en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		respuesta.put("status", "ok");
		respuesta.put("mensaje", "La categoria ha sido actualizada con éxito");
		respuesta.put("categoria", categoriaUpdate);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}
	
	
	
	
	

}
