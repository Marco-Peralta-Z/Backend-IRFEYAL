package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.EmpresaDAO;

import com.example.demo.models.entity.Empresa;
import com.example.demo.models.entity.Estudiante;

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
	@Transactional
	public Empresa saveEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
		return empresadao.save(empresa);
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

	@Override
	@Transactional(readOnly = true)
	public Empresa findById(Long id) {
		// TODO Auto-generated method stub
		return empresadao.findById(id).orElse(null);
	}

}
