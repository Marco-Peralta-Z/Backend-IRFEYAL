package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.interfaz.EmpleadoInterface;
import com.example.demo.models.dao.EmpleadoDAO;
import com.example.demo.models.entity.Empleado;


@Service
public class EmpleadoServiceImpl implements EmpleadoInterface{

	
	@Autowired
	private EmpleadoDAO empleadoDao;
	@Override
	
	public List<Empleado> findAll() {
		return (List<Empleado>) empleadoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Empleado> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return empleadoDao.findAll(pageable);
	}

	@Override
	public Empleado findById(Long id) {
		// TODO Auto-generated method stub
		return empleadoDao.findById(id).orElse(null);
	}

	@Override
	public Empleado saveEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		return empleadoDao.save(empleado);
	}

	@Override
	public void deleteEmpleado(Long id) {
		empleadoDao.deleteById(id);
		
	}

}
