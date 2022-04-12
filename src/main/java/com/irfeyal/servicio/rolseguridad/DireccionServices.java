package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.interfaz.DireccionInterface;
import com.example.demo.models.dao.DireccionDAO;

import com.example.demo.models.entity.Direccion;
import com.example.demo.models.entity.Empleado;
@Service
public class DireccionServices implements DireccionInterface {

	@Autowired
  private DireccionDAO direcciondao;

	@Override
	public List<Direccion> findAll() {
		// TODO Auto-generated method stub
		return (List<Direccion>) direcciondao.findAll();
	}
	@Override
	@Transactional(readOnly = true)
	public Page<Direccion> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return direcciondao.findAll(pageable);
	}

	@Override
	public Direccion findById(Long id) {
		// TODO Auto-generated method stub
		return direcciondao.findById(id).orElse(null);
	}

	@Override
	public Direccion saveDireccion(Direccion direccion) {
		// TODO Auto-generated method stub
		return direcciondao.save(direccion);
	}

	@Override
	public void deleteDireccion(Long id) {
		// TODO Auto-generated method stub
		direcciondao.deleteById(id);
	}
  
  
  


}
