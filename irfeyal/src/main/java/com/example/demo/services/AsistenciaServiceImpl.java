package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.models.dao.IAsistenciaDao;

import com.example.demo.models.entity.Asistencia;

@Service
public class AsistenciaServiceImpl implements IAsistenciaService{
	@Autowired
	private IAsistenciaDao asistenciadao;
	@Override
	public List<Asistencia> findAll() {
		// TODO Auto-generated method stub
		return  (List<Asistencia>) asistenciadao.findAll();
	}

	@Override
	public Asistencia findById(Long id) {
		// TODO Auto-generated method stub
		return asistenciadao.findById(id).orElse(null);
	}

	@Override
	public Asistencia save(Asistencia asistencia) {
		// TODO Auto-generated method stub
		return asistenciadao.save(asistencia);
	}

	@Override
	public void delete(Long id) {
		asistenciadao.deleteById(id);
		
	}

	

}
