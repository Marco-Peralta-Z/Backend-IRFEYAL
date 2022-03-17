package com.example.demo.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.entity.Rol;
import com.example.demo.services.RolServicesI;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapRol")
public class RolControler {

	@Autowired
	 private RolServicesI rol;
	
	@GetMapping ("/rol")
	
	public List<Rol> pais(){
	 return rol.findAll();
	}
	public List<Rol> paisdel(){
		 return rol.deleteRol();
		}
		
	public List<Rol> paissav(){
		 return rol.saveRol();
		}
		
	public List<Rol> paisupd(){
		 return rol.updateRol();
		}
		
	
}
