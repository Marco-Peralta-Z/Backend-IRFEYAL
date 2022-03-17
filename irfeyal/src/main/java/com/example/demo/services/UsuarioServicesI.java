package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.models.entity.Usuario;


public interface UsuarioServicesI {
	@Autowired

	public List<Usuario> findAll();
    public List<Usuario> saveUsuario();
    public List<Usuario> deleteUsuario();
    public List<Usuario> updateUsuario();

}
