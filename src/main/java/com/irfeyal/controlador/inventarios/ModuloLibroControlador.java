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

import com.irfeyal.modelo.inventarios.Aprobacion;
import com.irfeyal.modelo.inventarios.Inventario;
import com.irfeyal.modelo.inventarios.ModuloLibro;
import com.irfeyal.servicio.inventarios.AprobacionService;
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
	
	
	@RequestMapping(value = "/createmodulolibro", method = RequestMethod.POST)
    public ResponseEntity<ModuloLibro> create(@Valid @RequestBody ModuloLibro moduloLibro) {
		
		//System.out.print("------------>"+moduloLibro.getCodModulo());
        ModuloLibro moduloLibroReturn = modulolibroService.save(moduloLibro);
        
        if(moduloLibroReturn != null) {
        	System.out.print("------------>Entidad creada");
        }else {
        	System.out.print("------------>No se pudo gardar");
        }
        
        return new ResponseEntity(moduloLibroReturn, HttpStatus.CREATED);
        
        
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
	
	@GetMapping(produces = {"application/json"},path = "/eliminar")
	public boolean eliminarModuloLibro(@RequestParam("id") Long id){
		boolean validaElimModulibr = modulolibroService.delete(id);
		return validaElimModulibr;
	}
}
