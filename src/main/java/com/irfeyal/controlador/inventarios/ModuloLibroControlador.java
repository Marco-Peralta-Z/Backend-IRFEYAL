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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.inventarios.Aprobacion;
import com.irfeyal.modelo.inventarios.ModuloLibro;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;
import com.irfeyal.servicio.inventarios.ModulolibroService;

@RestController
@RequestMapping("/modulolibro")
@CrossOrigin(origins = "*")
public class ModuloLibroControlador {
	
	
	@Autowired
	ModulolibroService modulolibroService;
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<ModuloLibro> listaModuloLibro(){
		return modulolibroService.listAllModuloLibro();
	}
	
	@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> crearModulo(@Validated @RequestBody ModuloLibro moduloLibro, BindingResult result) {
		
		ModuloLibro nuevoModulo = null;
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
			nuevoModulo = modulolibroService.save(moduloLibro);
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al crear entidad");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("status", "ok");
		respuesta.put("modulo", nuevoModulo);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}
	
	@GetMapping(produces = {"application/json"})
	public ResponseEntity<Aprobacion> obtenerModuloLibro(@RequestParam("id") Long id){
		Optional<ModuloLibro> moduloLibro = this.modulolibroService.getById(id);
		if(moduloLibro.isPresent()) {
			return new ResponseEntity(moduloLibro.get(),HttpStatus.OK);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(path = "/eliminar{id}", produces = "application/json")
	public ResponseEntity<Map<String, Object>> eliminarModuloLibro(@PathVariable("id") Long idModulo) {
		Map<String, Object> respuesta = new HashMap<>();
		try {
			ModuloLibro moduloLibro = modulolibroService.delete(idModulo);
			if (moduloLibro == null) {
				respuesta.put("mensaje", "El modulo con id: " + idModulo + " no existe en la base de datos");
				return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al eliminar el modulo de la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("mensaje", "El Periodo ha sido eliminado");
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
	}
	
	@PutMapping(path = "/actualizar/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> actulaizarModuloLibro(@PathVariable("id") Long idModuloLibro, @Validated @RequestBody ModuloLibro moduloLibroModi,
			BindingResult result) {
		ModuloLibro moduloLibroActual = modulolibroService.getById(idModuloLibro).get();
		ModuloLibro moduloLibroUpdate = null;
		Map<String, Object> respuesta = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(error -> "Error en el atributo: " + error.getField() + ": " + error.getDefaultMessage())
					.collect(Collectors.toList());
			respuesta.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		if (moduloLibroActual == null) {
			respuesta.put("mensaje", "Error: no se pudo editar el modulo: "
					.concat(idModuloLibro.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		try {
			//Actualizando periodo
			moduloLibroActual.setCantidad(moduloLibroModi.getCantidad());
			moduloLibroActual.setCodModulo(moduloLibroModi.getCodModulo());
			moduloLibroActual.setCurso(moduloLibroModi.getCurso());
			moduloLibroActual.setNombreModulo(moduloLibroModi.getNombreModulo());
			moduloLibroActual.setNumero(moduloLibroModi.getNumero());
			moduloLibroActual.setNumeroModulo(moduloLibroModi.getNumeroModulo());
			moduloLibroUpdate = modulolibroService.update(moduloLibroActual);
			
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al realizar el update en la base de datos");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.BAD_REQUEST);
		}
		respuesta.put("mensaje", "El modulo ha sido actualizado con éxito");
		respuesta.put("periodo", moduloLibroUpdate);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}
	
	
	
	
	
}
