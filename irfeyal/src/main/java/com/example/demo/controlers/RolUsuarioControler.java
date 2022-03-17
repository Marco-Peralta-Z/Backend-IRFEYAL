package com.example.demo.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.entity.RolUsuario;
import com.example.demo.services.RolUsuarioServiceI;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapRolUsuario")
public class RolUsuarioControler {
	
	@Autowired
	 private RolUsuarioServiceI rolusuario;
	
	@GetMapping ("/pais")
	
	public List<RolUsuario> rolusuario(){
	 return rolusuario.findAll();
	}
	public List<RolUsuario> rolusuariodel(){
		 return rolusuario.deleteRolUsuario();
		}
		
	public List<RolUsuario> rolusuariosav(){
		 return rolusuario.saveRolUsuario();
		}
		
	public List<RolUsuario> rolusuarioupd(){
		 return rolusuario.updateRolUsuario();
		}
		
}
