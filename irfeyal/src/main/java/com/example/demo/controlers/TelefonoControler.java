package com.example.demo.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Telefono;
import com.example.demo.services.TelefonoServicesI;

@RestController
@RequestMapping("/telefono")
@CrossOrigin(origins = "*")
public class TelefonoControler {

	@Autowired
	private TelefonoServicesI telefono;

	@GetMapping(path = "/list", produces = { "application/json" })
	public List<Telefono> telefono() {
		return telefono.findAll();
	}

}
