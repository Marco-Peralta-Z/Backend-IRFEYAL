package com.irfeyal.controlador.inventarios;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import com.irfeyal.modelo.inventarios.Kit;
import com.irfeyal.modelo.inventarios.ModuloLibro;
import com.irfeyal.modelo.parametrizacionacademica.Malla;
import com.irfeyal.servicio.inventarios.IKitService;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/kit")
@CrossOrigin(origins = "*")
public class KitControlador {
	
	@Autowired//(required = false)
	//@Qualifier("IAutoServiceImplement")
	IKitService kitService;
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<Kit> listKit(){
		return kitService.listAllKit();
		
	}
	
	@PostMapping(path = "/crearkit", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> crearKit(@Validated @RequestBody Kit kit, BindingResult result) {

		Kit kitNuevo = kitService.save(kit, result);

		return new ResponseEntity(kitNuevo, HttpStatus.CREATED);
    }
	
	
	
	
	
	@GetMapping(produces = {"application/json"})
	public ResponseEntity<Kit> obtenerKit(@RequestParam("id") Long id){
		Optional<Kit> optionalKit = this.kitService.getById(id);
		if(optionalKit.isPresent()) {
			return new ResponseEntity(optionalKit.get(),HttpStatus.OK);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
