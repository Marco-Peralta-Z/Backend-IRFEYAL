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
import com.irfeyal.modelo.inventarios.Categoria;
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
	
	@RequestMapping(value = "/crear/", method = RequestMethod.POST)
	public ResponseEntity<Categoria> crearCategoriaArticulo(@Valid @RequestBody Categoria categoria) {
		Categoria cate = categoriaService.save(categoria);
		if (cate != null) {
			return new ResponseEntity(cate, HttpStatus.CREATED);
		} else {
			System.out.print("empleado no encontrado");
		}

		return null;

	}
	
	

}
