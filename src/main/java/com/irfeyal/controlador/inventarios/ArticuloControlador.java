package com.irfeyal.controlador.inventarios;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.inventarios.AprobacionKit;
import com.irfeyal.modelo.inventarios.Articulo;
import com.irfeyal.modelo.inventarios.Categoria;
import com.irfeyal.modelo.rolseguridad.Empleado;
import com.irfeyal.servicio.inventarios.ArticuloService;

@RestController
@RequestMapping("/articulo")
@CrossOrigin(origins = "*")
public class ArticuloControlador {
	
	@Autowired
	private ArticuloService articuloService;
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<Articulo> listArticulo(){
		return articuloService.listAllArticulo();
	}
	
	
/*
 	@RequestMapping(value = "/crear/", method = RequestMethod.POST)
	public ResponseEntity<Aprobacion> crearArticulo(@Valid @RequestBody Aprobacion aprobacion) {

		Empleado emple = empleadoService.findById(aprobacion.getId_empleado_admin().getId_empleado());

		if (emple != null) {
			Aprobacion aprobacionReturn = aprobacionService.save(aprobacion,emple);

			if (aprobacionReturn != null) {
				System.out.print("------------>Entidad creada");
			} else {
				System.out.print("------------>No se pudo gardar");
			}

			return new ResponseEntity(aprobacionReturn, HttpStatus.CREATED);
		} else {
			System.out.print("empleado no encontrado");
		}

		return null;

	}
	
 * */
	
	
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


}
