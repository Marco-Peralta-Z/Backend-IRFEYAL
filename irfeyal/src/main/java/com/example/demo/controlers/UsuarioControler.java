package com.example.demo.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Usuario;
import com.example.demo.services.UsuarioServices;


@RestController
@RequestMapping(path = "/login")
@CrossOrigin(origins = "", maxAge = 3600)

public class UsuarioControler {
@Autowired UsuarioServices user;

@GetMapping(path = {"/inicio/{username}/{password}"})
public Usuario login (@PathVariable ("username") String username, @PathVariable ("password") String password)
{
	System.out.print("----------------------------");
	System.out.print("----------------------------");
	System.out.print("----------------------------");
	return user.login(username, password);
}
}
