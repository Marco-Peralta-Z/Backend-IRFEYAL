package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.interfaz.ModuloInterface;
import com.example.demo.models.dao.ModuloDAO;
import com.example.demo.models.entity.Modulo;

public class ModuloServices implements ModuloInterface{
	@Autowired
	private ModuloDAO modulodao;

	@Override
	public List<Modulo> findAll() {
		// TODO Auto-generated method stub
		return (List<Modulo>)modulodao;
	}

	@Override
	public Page<Modulo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return modulodao.findAll(pageable);
	}

	@Override
	public Modulo findById(Long id) {
		// TODO Auto-generated method stub
		return modulodao.findById(id).orElse(null);
	}

	@Override
	public Modulo saveModulo(Modulo modulo) {
		// TODO Auto-generated method stub
		return modulodao.save(modulo);
	}

	@Override
	public void deleteModulo(Long id) {
		// TODO Auto-generated method stub
		modulodao.deleteById(id);
	}

}
