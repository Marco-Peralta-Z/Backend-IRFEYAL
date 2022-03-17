package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.demo.models.entity.Pais;


public interface PaisServicesI  {

	
	@Autowired

	public List<Pais> findAll();
    public List<Pais> savePais();
    public List<Pais> deletePais();
    public List<Pais> updatePais();
}

