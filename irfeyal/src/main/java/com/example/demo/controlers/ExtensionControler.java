package com.example.demo.controlers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.entity.Extension;
import com.example.demo.services.ExtensionServicesI;




@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping ("/mapExtension")
public class ExtensionControler {

	@Autowired
	 private ExtensionServicesI extension;
	
	@GetMapping ("/extension")
	
	public List<Extension> pais(){
	 return extension.findAll();
	}
	public List<Extension> extensiondel(){
		 return extension.deleteExtension();
		}
		
	public List<Extension> extensionsav(){
		 return extension.saveExtension();
		}
		
	public List<Extension> extensionupd(){
		 return extension.updateExtension();
		}
		

	
}
