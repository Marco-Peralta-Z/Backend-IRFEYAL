package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.demo.models.entity.Rol;

public interface RolServicesI {
	@Autowired

	public List<Rol> findAll();
    public List<Rol> saveRol();
    public List<Rol> deleteRol();
    public List<Rol> updateRol();

}
