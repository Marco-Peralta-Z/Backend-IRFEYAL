package com.irfeyal.servicio.asistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.asistencia.IClaseService;
import com.irfeyal.modelo.asistencia.Clase;
import com.irfeyal.modelo.dao.asistencia.IClaseDao;

@Service
public class ClaseServiceImpl implements IClaseService{
	
	@Autowired
	private IClaseDao clasedao;

	@Override
	public Clase save(Clase clase) {
		// TODO Auto-generated method stub
		return clasedao.save(clase);
	}

	@Override
	public List<Clase> findAll() {
		// TODO Auto-generated method stub
		return clasedao.findAll();
	}

	@Override
	public List<Clase> mostrarfechas(Long idestudiante,Integer iddocente) {
		// TODO Auto-generated method stub
		return clasedao.mostrarfechasid(idestudiante, iddocente);
	}

	//CORREGIR 
	
	
	@Override
	public Clase ultimoingreso() {
		// TODO Auto-generated method stub
		return clasedao.findclaseingreseda();
	}
	
}
