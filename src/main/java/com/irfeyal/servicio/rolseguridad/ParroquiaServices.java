package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.interfaz.ParroquiaInterface;
import com.example.demo.models.dao.ParroquiaDAO;
import com.example.demo.models.entity.Parroquia;
@Service
public class ParroquiaServices implements ParroquiaInterface {

	
	@Autowired
  private ParroquiaDAO parroquiadao;

	@Override
	public List<Parroquia> findAll() {
		// TODO Auto-generated method stub
		return (List<Parroquia>)parroquiadao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Parroquia> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return parroquiadao.findAll(pageable);
	}

	@Override
	public Parroquia findById(Long id) {
		// TODO Auto-generated method stub
		return parroquiadao.findById(id).orElse(null);
	}

	@Override
	public Parroquia saveParroquia(Parroquia parroquia) {
		// TODO Auto-generated method stub
		return parroquiadao.save(parroquia);
	}

	@Override
	public void deleteParroquia(Long id) {
		// TODO Auto-generated method stub
		parroquiadao.deleteById(id);
	}
	

}
