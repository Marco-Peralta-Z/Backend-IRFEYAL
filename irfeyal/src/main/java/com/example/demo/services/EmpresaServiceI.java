package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.entity.Empresa;


public interface EmpresaServiceI {
	@Autowired

	public List<Empresa> findAll();
    public List<Empresa> saveEmpresa();
    public List<Empresa> deleteEmpresa();
    public List<Empresa> updateEmpresa();
}
