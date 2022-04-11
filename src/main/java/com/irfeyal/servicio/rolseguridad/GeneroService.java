package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.interfaz.GeneroInterface;
import com.example.demo.models.dao.GeneroDAO;

import com.example.demo.models.entity.Genero;

@Service
public class GeneroService implements GeneroInterface {
	@Autowired
	  private GeneroDAO generodao;

	@Override
	public List<Genero> findAll() {
		// TODO Auto-generated method stub
		return (List<Genero>)generodao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Genero> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return generodao.findAll(pageable);
	}

	@Override
	public Genero findById(Long id) {
		// TODO Auto-generated method stub
		return generodao.findById(id).orElse(null);
	}

	@Override
	public Genero saveGenero(Genero genero) {
		// TODO Auto-generated method stub
		return generodao.save(genero);
	}

	@Override
	public void deleteGenero(Long id) {
		// TODO Auto-generated method stub
		generodao.deleteById(id);
	}
	  
	  


}
