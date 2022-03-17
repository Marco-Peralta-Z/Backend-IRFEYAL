package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.CantonDAO;
import com.example.demo.models.entity.Canton;


@Service
public class CantonService implements CantonServiceI {
	
	@Autowired
	  private CantonDAO cantdao;

	@Override
	public List<Canton> findAll() {
		// TODO Auto-generated method stub
		return (List<Canton>) cantdao.findAll();
	}

	@Override
	public List<Canton> saveCanton() {
		// TODO Auto-generated method stub
		return (List<Canton>) cantdao.findAll();
	}

	@Override
	public List<Canton> deleteCanton() {
		// TODO Auto-generated method stub
		return (List<Canton>) cantdao.findAll();
	}

	@Override
	public List<Canton> updateCanton() {
		// TODO Auto-generated method stub
		return (List<Canton>) cantdao.findAll();
	}




}
