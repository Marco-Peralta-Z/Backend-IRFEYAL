package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.entity.Direccion;



public interface DireccionServicesI {
	@Autowired

	public List<Direccion> findAll();
    public List<Direccion> saveDireccion();
    public List<Direccion> deleteDireccion();
    public List<Direccion> updateDireccion();
	
}
