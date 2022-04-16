package com.irfeyal.servicio.rolseguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irfeyal.interfaces.rolseguridad.EmpresaInterface;
import com.irfeyal.modelo.dao.rolseguridad.EmpresaDAO;
import com.irfeyal.modelo.rolseguridad.Empresa;

@Service
public class EmpresaService implements EmpresaInterface{

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
	@Transactional(readOnly = true)
	public Empresa findById(Long id) {
		// TODO Auto-generated method stub
		return empresadao.findById(id).orElse(null);
	}

	@Override
	public void deleteEmpresa(Long id) {
		// TODO Auto-generated method stub
	  empresadao.findById(id);
	}

	@Override
	public List<Empresa> updateEmpresa() {
		// TODO Auto-generated method stub
		return (List<Empresa>) empresadao.findAll();
	}
	
	
}
