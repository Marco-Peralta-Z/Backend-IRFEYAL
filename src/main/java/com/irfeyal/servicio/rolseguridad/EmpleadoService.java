package com.irfeyal.servicio.rolseguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irfeyal.interfaces.rolseguridad.EmpleadoInterface;
import com.irfeyal.modelo.dao.rolseguridad.EmpleadoDAO;
import com.irfeyal.modelo.rolseguridad.Empleado;


@Service
public class EmpleadoService implements EmpleadoInterface{

	
	@Autowired (required = true)
	private EmpleadoDAO empleadoDao;

	@Override
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		empleadoDao.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public List<Empleado> findAllByCedula(String cedula) {
		// TODO Auto-generated method stub
		return empleadoDao.findAllEmpleadosByCedula(cedula);
	}

	
	
	
}
