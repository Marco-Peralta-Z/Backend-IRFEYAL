package com.example.demo.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Genero;
import com.example.demo.services.GeneroServiceI;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapGenero")
public class GeneroControler {

	@Autowired
	 private GeneroServiceI genero;
	
	@GetMapping ("/genero")
	
	public List<Genero> genero(){
	 return genero.findAll();
	}
	public List<Genero> generodel(){
		 return genero.deleteGenero();
		}
		
	public List<Genero> generosav(){
		 return genero.saveGenero();
		}
		
	public List<Genero> generoupd(){
		 return genero.updateGenero();
		}
		
	
	
}
