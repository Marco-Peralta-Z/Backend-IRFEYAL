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
import com.irfeyal.modelo.inventarios.Kit;
import com.irfeyal.modelo.rolseguridad.Empleado;
import com.irfeyal.servicio.inventarios.AprobacionService;


@RestController
@RequestMapping("/ingresokit")
@CrossOrigin(origins = "*")
public class IngresoKitControlador {
	
	
	
	


	
	
	

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
