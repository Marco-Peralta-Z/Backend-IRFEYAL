package com.example.demo.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Direccion;
import com.example.demo.services.DireccionServicesI;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapDireccion")
public class DireccionControler {
	@Autowired
	 private DireccionServicesI direccion;
	
	@GetMapping ("/direccion")
	
	public List<Direccion> direccion(){
	 return direccion.findAll();
	}
	public List<Direccion> direcciondel(){
		 return direccion.deleteDireccion();
		}
		
	public List<Direccion> direccionsav(){
		 return direccion.saveDireccion();
		}
		
	public List<Direccion> direccionupd(){
		 return direccion.updateDireccion();
		}
		
	
}
