package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.entity.Provincia;




public interface ProvinciaServicesI  {

	
	@Autowired

	public List<Provincia> findAll();
    public List<Provincia> saveProv();
    public List<Provincia> deleteProv();
    public List<Provincia> updateProv();
}
