package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.entity.Persona;



public interface PersonaServicesI {

	@Autowired

	public List<Persona> findAll();
    public List<Persona> savePersona();
    public List<Persona> deletePersona();
    public List<Persona> updatePersona();
}
