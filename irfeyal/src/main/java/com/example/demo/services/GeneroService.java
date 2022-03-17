package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.GeneroDAO;

import com.example.demo.models.entity.Genero;

@Service
public class GeneroService implements GeneroServiceI {
	@Autowired
	  private GeneroDAO generodao;
	  
	  
	@Override
	public List<Genero> findAll() {
		// TODO Auto-generated method stub
		return (List<Genero> ) generodao.findAll();
	}

	@Override
	public List<Genero> saveGenero() {
		// TODO Auto-generated method stub
		return (List<Genero> ) generodao.findAll();
	}

	@Override
	public List<Genero> deleteGenero() {
		// TODO Auto-generated method stub
		return (List<Genero> ) generodao.findAll();
	}

	@Override
	public List<Genero> updateGenero() {
		// TODO Auto-generated method stub
		return (List<Genero> ) generodao.findAll();
	}

}
