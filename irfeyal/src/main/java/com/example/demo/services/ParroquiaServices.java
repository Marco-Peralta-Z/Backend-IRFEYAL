package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.models.dao.ParroquiaDAO;
import com.example.demo.models.entity.Parroquia;
@Service
public class ParroquiaServices implements ParroquiaServiceI {

	
	@Autowired
  private ParroquiaDAO parroquiadao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Parroquia> findAll() {
		// TODO Auto-generated method stub
		return (List<Parroquia> ) parroquiadao.findAll();
	}

	@Override
	public List<Parroquia> saveParroquia() {
		// TODO Auto-generated method stub
		return (List<Parroquia> ) parroquiadao.findAll();
	}
	@Override
	public List<Parroquia> deleteParroquia() {
		// TODO Auto-generated method stub
		return (List<Parroquia> ) parroquiadao.findAll();
	}
	@Override
	public List<Parroquia> updateParroquia() {
		// TODO Auto-generated method stub
		return (List<Parroquia> ) parroquiadao.findAll();
	}
}
