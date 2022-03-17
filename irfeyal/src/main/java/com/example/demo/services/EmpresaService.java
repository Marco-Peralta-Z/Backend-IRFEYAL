package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.EmpresaDAO;

import com.example.demo.models.entity.Empresa;

@Service
public class EmpresaService implements EmpresaServiceI{

	@Autowired
	  private EmpresaDAO empresadao;
	
	@Override
	public List<Empresa> findAll() {
		// TODO Auto-generated method stub
		return (List<Empresa>) empresadao.findAll();
	}

	@Override
	public List<Empresa> saveEmpresa() {
		// TODO Auto-generated method stub
		return (List<Empresa>) empresadao.findAll();

	}

	@Override
	public List<Empresa> deleteEmpresa() {
		// TODO Auto-generated method stub
		return (List<Empresa>) empresadao.findAll();

	}

	@Override
	public List<Empresa> updateEmpresa() {
		// TODO Auto-generated method stub
		return (List<Empresa>) empresadao.findAll();

	}

}
