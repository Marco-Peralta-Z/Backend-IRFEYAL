package com.example.demo.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.entity.Persona;
import com.example.demo.services.PersonaServicesI;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapPersona")
public class PersonaControler {

	
	@Autowired
	 private PersonaServicesI persona;
	
	@GetMapping ("/pais")
	
	public List<Persona> persona(){
	 return persona.findAll();
	}
	public List<Persona> personadel(){
		 return persona.deletePersona();
		}
		
	public List<Persona> personasav(){
		 return persona.savePersona();
		}
		
	public List<Persona> personaupd(){
		 return persona.updatePersona();
		}
		
	
}
