package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.entity.Canton;


public interface CantonServiceI {
	@Autowired

	public List<Canton> findAll();
    public List<Canton> saveCanton();
    public List<Canton> deleteCanton();
    public List<Canton> updateCanton();
}
