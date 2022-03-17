package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.entity.Parroquia;



public interface ParroquiaServiceI {
	@Autowired

	public List<Parroquia> findAll();
    public List<Parroquia> saveParroquia();
    public List<Parroquia> deleteParroquia();
    public List<Parroquia> updateParroquia();
}
