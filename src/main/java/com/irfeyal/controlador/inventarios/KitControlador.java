package com.irfeyal.controlador.inventarios;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.irfeyal.modelo.inventarios.Kit;
import com.irfeyal.modelo.inventarios.ModuloLibro;
import com.irfeyal.servicio.inventarios.IKitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/kit")
@CrossOrigin(origins = "*")
public class KitControlador {
	
	@Autowired//(required = false)
	//@Qualifier("IAutoServiceImplement")
	IKitService kitService;
	
	@PostMapping("/kit/")
	public ResponseEntity<Kit> crearKit(@RequestBody Kit kit){
		return new ResponseEntity(this.kitService.save(kit),HttpStatus.CREATED);
	}

	@GetMapping(path = "/list", produces = {"application/json"})
	public List<Kit> listKit(){
		return kitService.listAllKit();
		
	}
	
	@RequestMapping(value = "/crearkit", method = RequestMethod.POST)
    public ResponseEntity<Kit> create(@Valid @RequestBody Kit kit) {
		
		//System.out.print("------------>"+moduloLibro.getCodModulo());
        Kit kitReturn = kitService.save(kit);
        
        if(kitReturn != null) {
        	System.out.print("------------>Entidad creada");
        }else {
        	System.out.print("------------>No se pudo gardar");
        }
        
        return new ResponseEntity(kitReturn, HttpStatus.CREATED);
        
        
    }
	
	@GetMapping(path="/id/", produces = {"application/json"})
	public ResponseEntity<Kit> obtenerKit(@PathVariable("id") Long id){
		Optional<Kit> optionalKit = this.kitService.getById(id);
		if(optionalKit.isPresent()) {
			return new ResponseEntity(optionalKit.get(),HttpStatus.OK);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
