package com.example.demo.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Empresa;
import com.example.demo.services.EmpresaServiceI;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapEmpresa")
public class EmpresaControler {
	@Autowired
	 private EmpresaServiceI empresa;
	
	@GetMapping ("/pais")
	
	public List<Empresa> empresa(){
	 return empresa.findAll();
	}
	public List<Empresa> empresadel(){
		 return empresa.deleteEmpresa();
		}
		
	public List<Empresa> empresasav(){
		 return empresa.saveEmpresa();
		}
		
	public List<Empresa> empresaupd(){
		 return empresa.updateEmpresa();
		}
		
	
}
