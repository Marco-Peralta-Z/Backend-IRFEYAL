package com.example.demo.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.models.entity.Provincia;

import com.example.demo.services.ProvinciaServicesI;


@RestController
@RequestMapping ("/mapProv")
public class ProvinciaControler {
		
		@Autowired
		 private ProvinciaServicesI provincia;
		
		@GetMapping ("/prov")
		
		public List<Provincia> provincia(){
		 return provincia.findAll();
		}
		public List<Provincia> provdel(){
			 return provincia.deleteProv();
			}
			
		public List<Provincia> provsav(){
			 return provincia.saveProv();
			}
			
		public List<Provincia> provsupd(){
			 return provincia.updateProv();
			}
			
		

	}
