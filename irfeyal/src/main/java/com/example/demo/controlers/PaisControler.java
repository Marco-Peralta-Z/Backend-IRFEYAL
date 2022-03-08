package com.example.demo.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Pais;
import com.example.demo.services.PaisServicesI;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapPais")

public class PaisControler {

	@Autowired
	 private PaisServicesI pais;
	
	@GetMapping ("/pais")
	
	public List<Pais> pais(){
	 return pais.findAll();
	}
	public List<Pais> paisdel(){
		 return pais.deletePais();
		}
		
	public List<Pais> paissav(){
		 return pais.savePais();
		}
		
	public List<Pais> paisupd(){
		 return pais.updatePais();
		}
		
	
	
	
	
}
