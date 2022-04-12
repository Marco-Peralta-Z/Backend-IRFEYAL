package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.interfaz.TelefonoInterface;
import com.example.demo.models.dao.TelefonoDAO;
import com.example.demo.models.entity.Telefono;
@Service
public class TelefonoServices implements TelefonoInterface {

	@Autowired
	  private TelefonoDAO telfdao;

	@Override
	public List<Telefono> findAll() {
		// TODO Auto-generated method stub
		return (List<Telefono>)telfdao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Telefono> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return telfdao.findAll(pageable);
	}

	@Override
	public Telefono findById(Long id) {
		// TODO Auto-generated method stub
		return telfdao.findById(id).orElse(null);
	}

	@Override
	public Telefono saveTelefono(Telefono telefono) {
		// TODO Auto-generated method stub
		return telfdao.save(telefono);
	}

	@Override
	public void deleteTelefono(Long id) {
		// TODO Auto-generated method stub
		telfdao.deleteById(id);
	}
	


}
