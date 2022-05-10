package com.irfeyal.controlador.inventarios;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irfeyal.modelo.inventarios.Aprobacion;
import com.irfeyal.modelo.inventarios.EntregaKit;
import com.irfeyal.modelo.inventarios.IngresoKit;
import com.irfeyal.modelo.inventarios.Kit;
import com.irfeyal.modelo.rolseguridad.Empleado;
import com.irfeyal.servicio.inventarios.AprobacionService;
import com.irfeyal.servicio.inventarios.IingresoKitService;


@RestController
@RequestMapping("/ingresokit")
@CrossOrigin(origins = "*")
public class IngresoKitControlador {
	
	@Autowired//(required = false)
	//@Qualifier("IAutoServiceImplement")
	IingresoKitService ingresoKitServicio;
	
	
	
	
	
	@RequestMapping(value = "/crearingresokit", method = RequestMethod.POST)
    public ResponseEntity<IngresoKit> create(@Valid @RequestBody IngresoKit ingresoKit) {
		
		
		
		Long secretaria = ingresoKit.getId_secretaria().getId_empleado();
		Long administrador = ingresoKit.getId_aprobacion().getId_empleado_admin().getId_empleado();
		
		if(secretaria != null && administrador != null ) {
			IngresoKit ingresoKitReturn = ingresoKitServicio.save(ingresoKit);
			System.out.println("Ingreso correcto");

			return new ResponseEntity(ingresoKitReturn, HttpStatus.CREATED);
		}else {
			
			System.out.println("no se pudo ingresar ingreso kit controlador");

			return null;
		}
		
		

	
		
		
		
		
    }
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<IngresoKit> listIngresoKit(){
		return ingresoKitServicio.listAllIngresoKit();
		
	}
	
	@GetMapping(produces = {"application/json"})
	public ResponseEntity<Aprobacion> obtenerKit(@RequestParam("id") Long id){
		Optional<IngresoKit> ingresKit = this.ingresoKitServicio.getById(id);
		if(ingresKit.isPresent()) {
			return new ResponseEntity(ingresKit.get(),HttpStatus.OK);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	

}


/*
 //System.out.print("------------>"+moduloLibro.getCodModulo());
		IngresoKit inresIngresoKitReturn = ingresoKitServicio.save(inresIngresoKit);
        if(inresIngresoKitReturn != null) {
        	System.out.print("------------>Entidad creada");
        }else {
        	System.out.print("------------>No se pudo gardar");
        }
        return new ResponseEntity(inresIngresoKitReturn, HttpStatus.CREATED);
 * */
