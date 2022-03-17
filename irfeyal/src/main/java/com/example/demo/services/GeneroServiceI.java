package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.entity.Genero;



public interface GeneroServiceI {
	@Autowired

	public List<Genero> findAll();
    public List<Genero> saveGenero();
    public List<Genero> deleteGenero();
    public List<Genero> updateGenero();
}
