package com.example.demo.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Canton;
import com.example.demo.services.CantonServiceI;



@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapCanton")


public class CantonControler {

	@Autowired
	 private CantonServiceI canton;
	
	@GetMapping ("/canton")
	
	public List<Canton> canton(){
	 return canton.findAll();
	}
	public List<Canton> cantondel(){
		 return canton.deleteCanton();
		}
		
	public List<Canton> cantonsav(){
		 return canton.saveCanton();
		}
		
	public List<Canton> cantonupd(){
		 return canton.updateCanton();
		}
		

		
}
