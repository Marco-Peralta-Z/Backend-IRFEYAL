package com.example.demo.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Usuario;
import com.example.demo.services.UsuarioServicesI;


@RestController
@RequestMapping(path = "/login")
public class UsuarioControler {
	
@Autowired UsuarioServicesI user;

@GetMapping
public Usuario login(@RequestParam (value="variable") String variable)
{
	//System.out.print("aaaaaaaaaaaaaaaaa"+variable);
	String var = "secre";
	return user.login(var, "123");
}
}
