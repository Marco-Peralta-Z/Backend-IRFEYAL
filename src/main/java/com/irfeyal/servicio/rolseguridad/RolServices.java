package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.interfaz.RolInterface;
import com.example.demo.models.dao.RolDAO;
import com.example.demo.models.entity.Pais;
import com.example.demo.models.entity.Rol;

@Service
public class RolServices implements RolInterface {
	

	@Autowired
  private RolDAO roldao;

	@Override
	public List<Rol> findAll() {
		// TODO Auto-generated method stub
		return (List<Rol>) roldao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Rol> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return roldao.findAll(pageable);
	}

	@Override
	public Rol findById(Long id) {
		// TODO Auto-generated method stub
		return roldao.findById(id).orElse(null);
	}

	@Override
	public Rol saveRol(Rol rol) {
		// TODO Auto-generated method stub
		return roldao.save(rol);
	}

	@Override
	public void deleteRol(Long id) {
		// TODO Auto-generated method stub
		roldao.deleteById(id);
	}
  



}
