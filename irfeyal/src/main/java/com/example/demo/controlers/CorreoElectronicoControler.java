package com.example.demo.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.CorreoElectronico;
import com.example.demo.services.CorreoElectronicoServicesI;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapCorreoElectronico")


public class CorreoElectronicoControler {

	@Autowired
	 private CorreoElectronicoServicesI correoElectronico;
	
	@GetMapping ("/correo")
	
	public List<CorreoElectronico> correoElectronico(){
	 return correoElectronico.findAll();
	}
	public List<CorreoElectronico> correodel(){
		 return correoElectronico.deleteCorreoElectronico();
		}
		
	public List<CorreoElectronico> correosav(){
		 return correoElectronico.saveCorreoElectronico();
		}
		
	public List<CorreoElectronico> correoupd(){
		 return correoElectronico.updateCorreoElectronico();
		}
	
}
