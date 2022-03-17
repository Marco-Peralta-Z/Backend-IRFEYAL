package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.demo.models.entity.RolUsuario;

public interface RolUsuarioServiceI {
	@Autowired

	public List<RolUsuario> findAll();
    public List<RolUsuario> saveRolUsuario();
    public List<RolUsuario> deleteRolUsuario();
    public List<RolUsuario> updateRolUsuario();
}
