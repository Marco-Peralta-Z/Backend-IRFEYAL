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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.inventarios.AprobacionKit;
import com.irfeyal.modelo.inventarios.Articulo;
import com.irfeyal.modelo.inventarios.Categoria;
import com.irfeyal.modelo.inventarios.ModuloLibro;
import com.irfeyal.modelo.rolseguridad.Empleado;
import com.irfeyal.servicio.inventarios.ArticuloService;
import com.irfeyal.servicio.inventarios.CategoriaService;

@RestController
@RequestMapping("/articulo")
@CrossOrigin(origins = "*")
public class ArticuloControlador {
	
	@Autowired
	private ArticuloService articuloService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<Articulo> listArticulo(){
		return articuloService.listAllArticulo();
	}

	
	
	@GetMapping(produces = {"application/json"})
	public ResponseEntity<AprobacionKit> obtenerArticulo(@RequestParam("id") Long id){
		Optional<Articulo> articulo = this.articuloService.getById(id);
		if(articulo.isPresent()) {
			return new ResponseEntity(articulo.get(),HttpStatus.OK);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	@GetMapping(produces = {"application/json"},value = "/eliminar/")
	public boolean eliminarArticulo(@RequestParam("id") Long id){
		boolean aprobacion = this.articuloService.delete(id);
		return aprobacion;
	}
	
	
	@PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> actulaizarModuloLibro(@PathVariable("id") Long idArticulo, @Validated @RequestBody Articulo articuloModificado,
			BindingResult result) {
		Articulo articuloActual = articuloService.getById(idArticulo).get();
		Articulo articuloUpdate = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		if (articuloActual == null) {
			respuesta.put("mensaje", "Error: no se pudo editar el modulo: "
					.concat(idArticulo.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			//Actualizando articulo
			articuloActual.setArtinombre(articuloModificado.getArtinombre());
			articuloActual.setArtiprecio(articuloModificado.getArtiprecio());
			articuloActual.setArtidescrip(articuloModificado.getArtidescrip());
			articuloActual.setArtimarca(articuloModificado.getArtimarca());
			Categoria cate = categoriaService.getById(articuloModificado.getCateId().getId_categoria()).get();
			articuloActual.setCateId(cate);
			articuloUpdate = articuloService.save(articuloUpdate);
			
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar el update en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		respuesta.put("status", "ok");
		respuesta.put("mensaje", "El articulo ha sido actualizado con éxito");
		respuesta.put("modulolibro", articuloUpdate);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}


}
