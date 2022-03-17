package com.example.demo.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.entity.Parroquia;

import com.example.demo.services.ParroquiaServiceI;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapParroquia")
public class ParroquiaControler {
	@Autowired
	 private ParroquiaServiceI parroquia;
	
	@GetMapping ("/parroquia")
	
	public List<Parroquia> pais(){
	 return parroquia.findAll();
	}
	public List<Parroquia> paisdel(){
		 return parroquia.deleteParroquia();
		}
		
	public List<Parroquia> paissav(){
		 return parroquia.saveParroquia();
		}
		
	public List<Parroquia> paisupd(){
		 return parroquia.updateParroquia();
		}
		
}
