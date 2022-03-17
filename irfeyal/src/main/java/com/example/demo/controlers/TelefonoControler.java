package com.example.demo.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Telefono;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapTelenofo")
public class TelefonoControler {

	@Autowired
	 private TelefonoControler telefono;
	
	@GetMapping ("/telefono")
	
	public List<Telefono> telefono(){
	 return telefono.telefono();
	}
	
	public List<Telefono> telefonodel(){
		 return telefono.telefonodel();
		}
		
	public List<Telefono> telefonosav(){
		 return telefono.telefonosav();
		}
		
	public List<Telefono> telefonoupd(){
		 return telefono.telefonoupd();
		}
	
	
}
